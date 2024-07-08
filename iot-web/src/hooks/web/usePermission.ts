import type { RouteRecordRaw } from 'vue-router'

import { intersection } from 'lodash-es'
import { useTabs } from './useTabs'
import { useAppStore } from '@/store/modules/app'
import { usePermissionStore } from '@/store/modules/permission'
import { useUserStore } from '@/store/modules/user'

import { resetRouter, router } from '@/router'

// import { RootRoute } from '@/router/routes';

import projectSetting from '@/settings/projectSetting'
import { PermissionModeEnum } from '@/enums/appEnum'
import type { RoleEnum } from '@/enums/roleEnum'

import { isArray } from '@/utils/is'
import { useMultipleTabStore } from '@/store/modules/multipleTab'

// User permissions related operations
export function usePermission() {
  const userStore = useUserStore()
  const appStore = useAppStore()
  const permissionStore = usePermissionStore()
  const { closeAll } = useTabs(router)

  /**
   * Change permission mode
   */
  function togglePermissionMode() {
    appStore.setProjectConfig({
      permissionMode: projectSetting.permissionMode
      === PermissionModeEnum.BACK
        ? PermissionModeEnum.ROUTE_MAPPING
        : PermissionModeEnum.BACK,
    })
    location.reload()
  }

  /**
   * Reset and regain authority resource information
   * 重置和重新获得权限资源信息
   */
  async function resume() {
    const tabStore = useMultipleTabStore()
    tabStore.clearCacheTabs()
    resetRouter()
    const routes = await permissionStore.buildRoutesAction()
    routes.forEach((route) => {
      try {
        router.addRoute(route as unknown as RouteRecordRaw)
      }
      catch (e) {}
    })
    permissionStore.setLastBuildMenuTime()
    closeAll()
  }

  /**
   * Determine whether there is permission
   */
  function hasPermission(value?: RoleEnum | RoleEnum[] | string | string[], def = true): boolean {
    // Visible by default
    if (!value)
      return def

    const permMode = appStore.getProjectConfig.permissionMode

    if ([PermissionModeEnum.ROUTE_MAPPING, PermissionModeEnum.ROLE].includes(permMode)) {
      if (!isArray(value))
        return userStore.getRoleList?.includes(value as RoleEnum)

      return (intersection(value, userStore.getRoleList) as RoleEnum[]).length > 0
    }

    if (PermissionModeEnum.BACK === permMode) {
      const allCodeList = permissionStore.getPermCodeList as string[]
      if (!isArray(value))
        return allCodeList.includes(value)

      return (intersection(value, allCodeList)).length > 0
    }
    return true
  }

  /**
   * Change roles
   * @param roles
   */
  async function changeRole(roles: RoleEnum | RoleEnum[]): Promise<void> {
    if (projectSetting.permissionMode !== PermissionModeEnum.ROUTE_MAPPING)
      throw new Error('Please switch PermissionModeEnum to ROUTE_MAPPING mode in the configuration to operate!')

    if (!isArray(roles))
      roles = [roles]

    userStore.setRoleList(roles)
    await resume()
  }

  /**
   * refresh menu data
   */
  function refreshMenu() {
    resume()
  }

  return { changeRole, hasPermission, togglePermissionMode, refreshMenu }
}
