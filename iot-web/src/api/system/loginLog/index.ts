import { defHttp } from '@/utils/http/axios'

export interface LoginLogVO {
  id: number
  logType: number
  traceId: number
  userId: number
  userType: number
  username: string
  status: number
  userIp: string
  userAgent: string
  createTime: Date
}

export interface LoginLogReqVO extends PageParam {
  userIp?: string
  username?: string
  status?: boolean
  createTime?: Date[]
}

// 查询登录日志列表
export function getLoginLogPage(params: LoginLogReqVO) {
  return defHttp.get({ url: '/system/login-log/page', params })
}
// 导出登录日志
export function exportLoginLog(params: LoginLogReqVO) {
  return defHttp.download({ url: '/system/login-log/export', params }, '登录日志.xls')
}
