import { nextTick, ref, toRaw } from 'vue'
import type { RouteLocationNormalized } from 'vue-router'
import { useRouter } from 'vue-router'
import { useI18n } from '@/hooks/web/useI18n'
import { useDesign } from '@/hooks/web/useDesign'
import { useSortable } from '@/hooks/web/useSortable'
import { useMultipleTabStore } from '@/store/modules/multipleTab'
import { isNil } from '@/utils/is'
import projectSetting from '@/settings/projectSetting'

const { t } = useI18n()

export function initAffixTabs(): string[] {
  const affixList = ref<RouteLocationNormalized[]>([])

  const tabStore = useMultipleTabStore()
  const router = useRouter()
  /**
   * @description: Filter all fixed routes
   */
  function filterAffixTabs(routes: RouteLocationNormalized[]) {
    const tabs: RouteLocationNormalized[] = []
    routes
      && routes.forEach((route) => {
        if (route.meta && route.meta.affix)
          tabs.push(toRaw(route))
      })
    return tabs
  }

  /**
   * @description: Set fixed tabs
   */
  function addAffixTabs(): void {
    const affixTabs = filterAffixTabs(router.getRoutes() as unknown as RouteLocationNormalized[])
    affixList.value = affixTabs
    for (const tab of affixTabs) {
      tabStore.addTab({
        meta: tab.meta,
        name: tab.name,
        path: tab.path,
      } as unknown as RouteLocationNormalized)
    }
  }

  let isAddAffix = false

  if (!isAddAffix) {
    addAffixTabs()
    isAddAffix = true
  }
  return affixList.value.map(item => item.meta?.title).filter(Boolean)
}

export function useTabsDrag(affixTextList: string[]) {
  const tabStore = useMultipleTabStore()
  const { multiTabsSetting } = projectSetting
  const { prefixCls } = useDesign('multiple-tabs')
  nextTick(() => {
    if (!multiTabsSetting.canDrag)
      return
    const el = document.querySelectorAll(`.${prefixCls} .ant-tabs-nav-wrap > div`)?.[0] as HTMLElement
    const { initSortable } = useSortable(el, {
      filter: (_evt, target: HTMLElement) => {
        const text = target.textContent
        if (!text)
          return false
        return affixTextList.map(res => t(res)).includes(text)
      },
      onEnd: (evt) => {
        const { oldIndex, newIndex } = evt

        if (isNil(oldIndex) || isNil(newIndex) || oldIndex === newIndex)
          return

        tabStore.sortTabs(oldIndex, newIndex)
      },
    })
    initSortable()
  })
}
