import Vue from 'vue'

import Cookies from 'js-cookie'

import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import '@/assets/styles/index.scss' // global css
import '@/assets/styles/ruoyi.scss' // ruoyi css
import App from './App'
import store from './store'
import router from './router'
import directive from './directive' //directive
import plugins from './plugins' // plugins
import {
  download
} from '@/utils/request'

import './assets/icons' // icon
import './permission' // permission control
import {
  getDicts
} from "@/api/system/dict/data";
import {
  getConfigKey
} from "@/api/system/config";
import {
  parseTime,
  resetForm,
  addDateRange,
  selectDictLabel,
  selectDictLabels,
  handleTree
} from "@/utils/basiclabiot";
// 分页组件
import Pagination from "@/components/Pagination";
// 自定义表格工具组件
import RightToolbar from "@/components/RightToolbar"
// 富文本组件
import Editor from "@/components/Editor"
// 文件上传组件
import FileUpload from "@/components/FileUpload"
// 图片上传组件
import ImageUpload from "@/components/ImageUpload"
// 字典标签组件
import DictTag from '@/components/DictTag'
// 头部标签组件
import VueMeta from 'vue-meta'
// 字典数据组件
import DictData from '@/components/DictData'
// 引入百度地图
import BaiduMap from 'vue-baidu-map'


// 引入高德
import AmapVue from '@amap/amap-vue';
AmapVue.config.version = '2.0'; // 默认2.0，这里可以不修改
AmapVue.config.key = 'a7875e62299794a32054f208842e0c34'; //服务平台选择 Web端(JS API)
AmapVue.config.plugins = [
  'AMap.moveAnimation',
  'AMap.Geocoder',
  'AMap.AutoComplete',
  'AMap.PlaceSearch',
  // 在此配置你需要预加载的插件，如果不配置，在使用到的时候会自动异步加载
];
// 新版本的Web端开发者安全密钥
window._AMapSecurityConfig = {
  securityJsCode: "51346fc6439b2d535eff510407d3a5bb",
};
Vue.use(AmapVue);

// 全局方法挂载
Vue.prototype.getDicts = getDicts
Vue.prototype.getConfigKey = getConfigKey
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.selectDictLabel = selectDictLabel
Vue.prototype.selectDictLabels = selectDictLabels
Vue.prototype.download = download
Vue.prototype.handleTree = handleTree

// 全局组件挂载
Vue.component('DictTag', DictTag)
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)
Vue.component('Editor', Editor)
Vue.component('FileUpload', FileUpload)
Vue.component('ImageUpload', ImageUpload)


Vue.use(directive)
Vue.use(plugins)
Vue.use(VueMeta)
DictData.install()


// 全局注册basiclabiot专属组件
import components from './components/basiclabiotComponents'
Object.keys(components).forEach(key => {
  const component = components[key]
  Vue.component(component.name, component)
})

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online! ! !
 */

Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
})

Vue.use(BaiduMap, {
  ak: 'GRDscTDALCFC14GMv7TgTG1kxXV7yypD'
});

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
