import { defHttp } from '@/utils/http/axios'

export interface ApiErrorLogVO {
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
  exceptionTime: Date
  exceptionName: string
  exceptionMessage: string
  exceptionRootCauseMessage: string
  exceptionStackTrace: string
  exceptionClassName: string
  exceptionFileName: string
  exceptionMethodName: string
  exceptionLineNumber: number
  processUserId: number
  processStatus: number
  processTime: Date
  resultCode: number
  createTime: Date
}

export interface ApiErrorLogPageReqVO extends PageParam {
  userId?: number
  userType?: number
  applicationName?: string
  requestUrl?: string
  exceptionTime?: Date[]
  processStatus: number
}

export interface ApiErrorLogExportReqVO {
  userId?: number
  userType?: number
  applicationName?: string
  requestUrl?: string
  exceptionTime?: Date[]
  processStatus: number
}

// 查询列表API 访问日志
export function getApiErrorLogPage(params: ApiErrorLogPageReqVO) {
  return defHttp.get({ url: '/infra/api-error-log/page', params })
}

// 更新 API 错误日志的处理状态
export function updateApiErrorLogProcess(id: number, processStatus: number) {
  return defHttp.put({
    url: `/infra/api-error-log/update-status?id=${id}&processStatus=${processStatus}`,
  })
}

// 导出API 错误日志
export function exportApiErrorLog(params: ApiErrorLogExportReqVO) {
  return defHttp.download(
    {
      url: '/infra/api-error-log/export-excel',
      params,
    },
    '错误日志.xls',
  )
}
