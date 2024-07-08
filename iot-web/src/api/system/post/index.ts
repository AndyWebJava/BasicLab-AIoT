import { defHttp } from '@/utils/http/axios'

export interface PostVO {
  id?: number
  name: string
  code: string
  sort: number
  status: number
  remark: string
  createTime?: Date
}

export interface PostPageReqVO extends PageParam {
  code?: string
  name?: string
  status?: number
}

export interface PostExportReqVO {
  code?: string
  name?: string
  status?: number
}

// 查询岗位列表
export function getPostPage(params: PostPageReqVO) {
  return defHttp.get<PageResult<PostVO>>({ url: '/system/post/page', params })
}

// 获取岗位精简信息列表
export function listSimplePosts() {
  return defHttp.get({ url: '/system/post/list-all-simple' })
}

// 查询岗位详情
export function getPost(id: number) {
  return defHttp.get({ url: `/system/post/get?id=${id}` })
}

// 新增岗位
export function createPost(data) {
  return defHttp.post({ url: '/system/post/create', data })
}

// 修改岗位
export function updatePost(data) {
  return defHttp.put({ url: '/system/post/update', data })
}

// 删除岗位
export function deletePost(id: number) {
  return defHttp.delete({ url: `/system/post/delete?id=${id}` })
}

// 导出岗位
export function exportPost(params: PostExportReqVO) {
  return defHttp.download({ url: '/system/post/export', params }, '导出岗位.xls')
}
