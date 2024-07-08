import { defHttp } from '@/utils/http/axios'

export interface RefundVO {
  id: number
  merchantId: number
  appId: number
  channelId: number
  channelCode: string
  orderId: string
  tradeNo: string
  merchantOrderId: string
  merchantRefundNo: string
  notifyUrl: string
  notifyStatus: number
  status: number
  type: number
  payAmount: number
  refundAmount: number
  reason: string
  userIp: string
  channelOrderNo: string
  channelRefundNo: string
  channelErrorCode: string
  channelErrorMsg: string
  channelExtras: string
  expireTime: Date
  successTime: Date
  notifyTime: Date
  createTime: Date
}

export interface RefundPageReqVO extends PageParam {
  merchantId?: number
  appId?: number
  channelId?: number
  channelCode?: string
  orderId?: string
  tradeNo?: string
  merchantOrderId?: string
  merchantRefundNo?: string
  notifyUrl?: string
  notifyStatus?: number
  status?: number
  type?: number
  payAmount?: number
  refundAmount?: number
  reason?: string
  userIp?: string
  channelOrderNo?: string
  channelRefundNo?: string
  channelErrorCode?: string
  channelErrorMsg?: string
  channelExtras?: string
  expireTime?: Date[]
  successTime?: Date[]
  notifyTime?: Date[]
  createTime?: Date[]
}

export interface PayRefundExportReqVO {
  merchantId?: number
  appId?: number
  channelId?: number
  channelCode?: string
  orderId?: string
  tradeNo?: string
  merchantOrderId?: string
  merchantRefundNo?: string
  notifyUrl?: string
  notifyStatus?: number
  status?: number
  type?: number
  payAmount?: number
  refundAmount?: number
  reason?: string
  userIp?: string
  channelOrderNo?: string
  channelRefundNo?: string
  channelErrorCode?: string
  channelErrorMsg?: string
  channelExtras?: string
  expireTime?: Date[]
  successTime?: Date[]
  notifyTime?: Date[]
  createTime?: Date[]
}

// 查询列表退款订单
export function getRefundPage(params: RefundPageReqVO) {
  return defHttp.get({ url: '/pay/refund/page', params })
}

// 查询详情退款订单
export function getRefund(id: number) {
  return defHttp.get({ url: `/pay/refund/get?id=${id}` })
}

// 新增退款订单
export function createRefund(data: RefundVO) {
  return defHttp.post({ url: '/pay/refund/create', data })
}

// 修改退款订单
export function updateRefund(data: RefundVO) {
  return defHttp.put({ url: '/pay/refund/update', data })
}

// 删除退款订单
export function deleteRefund(id: number) {
  return defHttp.delete({ url: `/pay/refund/delete?id=${id}` })
}

// 导出退款订单
export function exportRefund(params: PayRefundExportReqVO) {
  return defHttp.download({ url: '/pay/refund/export-excel', params }, '退款订单.xls')
}
