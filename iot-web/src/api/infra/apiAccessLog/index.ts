import { defHttp } from '@/utils/http/axios'

export interface ApiAccessLogVO {
  id: number
  traceId: string
  userId: number
  userType: number
  applicationName: string
  requestMethod: string
  requestParams: string
  requestUrl: string
  userIp: string
  userAgent: string
  beginTime: Date
  endTIme: Date
  duration: number
  resultCode: number
  resultMsg: string
  createTime: Date
}

export interface ApiAccessLogPageReqVO extends PageParam {
  userId?: number
  userType?: number
  applicationName?: string
  requestUrl?: string
  beginTime?: Date[]
  duration?: number
  resultCode?: number
}

export interface ApiAccessLogExportReqVO {
  userId?: number
  userType?: number
  applicationName?: string
  requestUrl?: string
  beginTime?: Date[]
  duration?: number
  resultCode?: number
}

// 查询列表API 访问日志
export function getApiAccessLogPage(params: ApiAccessLogPageReqVO) {
  return defHttp.get({ url: '/infra/api-access-log/page', params })
}

// 导出API 访问日志
export function exportApiAccessLog(params: ApiAccessLogExportReqVO) {
  return defHttp.download({ url: '/infra/api-access-log/export-excel', params }, '访问日志.xls')
}
