import { getSimpleGroupList } from '@/api/member/group'
import { getSimpleLevelList } from '@/api/member/level'
import { getSimpleTagList } from '@/api/member/tag'
import { getAreaTree } from '@/api/system/area'
import type { DescItem } from '@/components/Description'
import type { BasicColumn, FormSchema } from '@/components/Table'
import { useRender } from '@/components/Table'
import { DICT_TYPE, getDictOptions } from '@/utils/dict'

export const columns: BasicColumn[] = [
  {
    title: '用户编号',
    dataIndex: 'id',
    width: 100,
  },
  {
    title: '头像',
    dataIndex: 'avatar',
    width: 180,
    customRender: ({ text }) => {
      return useRender.renderImg(text)
    },
  },
  {
    title: '手机号',
    dataIndex: 'mobile',
    width: 100,
  },
  {
    title: '昵称',
    dataIndex: 'nickname',
    width: 100,
  },
  {
    title: '等级',
    dataIndex: 'levelName',
    width: 100,
  },
  {
    title: '分组',
    dataIndex: 'groupName',
    width: 100,
  },
  {
    title: '用户标签',
    dataIndex: 'tagNames',
    width: 100,
    customRender: ({ text }) => {
      return useRender.renderTags(text)
    },
  },
  {
    title: '积分',
    dataIndex: 'point',
    width: 100,
  },
  {
    title: '状态',
    dataIndex: 'status',
    width: 180,
    customRender: ({ text }) => {
      return useRender.renderDict(text, DICT_TYPE.COMMON_STATUS)
    },
  },
  {
    title: '登录时间',
    dataIndex: 'loginDate',
    customRender: ({ text }) => {
      return useRender.renderDate(text)
    },
  },
  {
    title: '注册时间',
    dataIndex: 'createTime',
    customRender: ({ text }) => {
      return useRender.renderDate(text)
    },
  },
]

export const searchFormSchema: FormSchema[] = [
  {
    label: '用户昵称',
    field: 'nickname',
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    label: '手机号',
    field: 'mobile',
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    label: '注册时间',
    field: 'createTime',
    component: 'RangePicker',
    colProps: { span: 8 },
  },
  {
    label: '登录时间',
    field: 'loginDate',
    component: 'RangePicker',
    colProps: { span: 8 },
  },
  {
    label: '用户标签',
    field: 'tagIds',
    component: 'ApiSelect',
    componentProps: {
      api: () => getSimpleTagList(),
      labelField: 'name',
      valueField: 'id',
    },
    colProps: { span: 8 },
  },
  {
    label: '用户等级',
    field: 'levelId',
    component: 'ApiSelect',
    componentProps: {
      api: () => getSimpleLevelList(),
      labelField: 'name',
      valueField: 'id',
    },
    colProps: { span: 8 },
  },
  {
    label: '用户分组',
    field: 'groupId',
    component: 'ApiSelect',
    componentProps: {
      api: () => getSimpleGroupList(),
      labelField: 'name',
      valueField: 'id',
    },
    colProps: { span: 8 },
  },
]

export const formSchema: FormSchema[] = [
  {
    label: '编号',
    field: 'id',
    show: false,
    component: 'Input',
  },
  {
    label: '手机号',
    field: 'mobile',
    required: true,
    component: 'Input',
  },
  {
    label: '状态',
    field: 'status',
    component: 'Select',
    componentProps: {
      options: getDictOptions(DICT_TYPE.COMMON_STATUS),
    },
  },
  {
    label: '用户昵称',
    field: 'nickname',
    component: 'Input',
  },
  {
    label: '用户头像',
    field: 'avatar',
    component: 'FileUpload',
    componentProps: {
      maxCount: 1,
      fileType: 'image',
    },
  },
  {
    label: '真实名字',
    field: 'name',
    component: 'Input',
  },
  {
    label: '用户性别',
    field: 'sex',
    component: 'Select',
    componentProps: {
      options: getDictOptions(DICT_TYPE.SYSTEM_USER_SEX),
    },
  },
  {
    label: '出生日期',
    field: 'birthday',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'x',
    },
  },
  {
    label: '所在地',
    field: 'areaId',
    component: 'ApiTreeSelect',
    componentProps: {
      api: () => getAreaTree(),
      handleTree: 'id',
    },
  },
  {
    label: '用户标签',
    field: 'tagIds',
    component: 'ApiSelect',
    componentProps: {
      api: () => getSimpleTagList(),
      labelField: 'name',
      valueField: 'id',
    },
  },
  {
    label: '用户分组',
    field: 'groupId',
    component: 'ApiSelect',
    componentProps: {
      api: () => getSimpleGroupList(),
      labelField: 'name',
      valueField: 'id',
    },
  },
  {
    label: '会员备注',
    field: 'mark',
    component: 'InputTextArea',
  },
]

export const updateLevelFormSchema: FormSchema[] = [
  {
    label: '编号',
    field: 'id',
    show: false,
    component: 'Input',
  },
  {
    label: '用户昵称',
    field: 'nickname',
    dynamicDisabled: true,
    component: 'Input',
  },
  {
    label: '用户等级',
    field: 'levelId',
    component: 'ApiSelect',
    componentProps: {
      api: () => getSimpleLevelList(),
      labelField: 'name',
      valueField: 'id',
    },
  },
  {
    label: '修改原因',
    field: 'reason',
    required: true,
    component: 'InputTextArea',
  },
]

export const userBasicInfoDesc: DescItem[] = [
  {
    label: '用户名',
    field: 'name',
  },
  {
    label: '昵称',
    field: 'nickname',
  },
  {
    label: '手机号',
    field: 'mobile',
  },
  {
    label: '性别',
    field: 'sex',
    render: (curVal) => {
      return useRender.renderDict(curVal, DICT_TYPE.SYSTEM_USER_SEX)
    },
  },
  {
    label: '所在地',
    field: 'areaName',
  },
  {
    label: '注册 IP',
    field: 'registerIp',
  },
  {
    label: '生日',
    field: 'birthday',
    render: (curVal) => {
      return useRender.renderDate(curVal)
    },
  },
  {
    label: '注册时间',
    field: 'createTime',
    render: (curVal) => {
      return useRender.renderDate(curVal)
    },
  },
  {
    label: '最后登录时间',
    field: 'loginDate',
    render: (curVal) => {
      return useRender.renderDate(curVal)
    },
  },
]

export const userAccountInfoDesc: DescItem[] = [
  {
    label: '等级',
    field: 'levelName',
  },
  {
    label: '成长值',
    field: 'experience',
    render: (curVal) => {
      return curVal || 0
    },
  },
  {
    label: '当前积分',
    field: 'point',
    render: (curVal) => {
      return curVal || 0
    },
  },
  {
    label: '总积分',
    field: 'totalPoint',
    render: (curVal) => {
      return curVal || 0
    },
  },
  {
    label: '当前余额',
    field: 'aaa',
    render: (curVal) => {
      return curVal || 0
    },
  },
  {
    label: '支出金额',
    field: 'bbb',
    render: (curVal) => {
      return curVal || 0
    },
  },
  {
    label: '充值金额',
    field: 'ccc',
    render: (curVal) => {
      return curVal || 0
    },
  },
]
