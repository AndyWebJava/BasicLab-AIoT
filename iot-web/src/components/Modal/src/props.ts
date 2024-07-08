import type { CSSProperties } from 'vue'
import type { ButtonProps } from 'ant-design-vue/es/button/buttonTypes'
import type { ModalWrapperProps } from './typing'
import { useI18n } from '@/hooks/web/useI18n'

const { t } = useI18n()

export const modalProps = {
  open: { type: Boolean },
  scrollTop: { type: Boolean, default: true },
  height: { type: Number },
  minHeight: { type: Number, default: 600 },
  // open drag
  draggable: { type: Boolean, default: true },
  centered: { type: Boolean },
  cancelText: { type: String, default: t('common.cancelText') },
  okText: { type: String, default: t('common.okText') },

  closeFunc: Function as PropType<() => Promise<boolean>>,
}

export const basicProps = Object.assign({}, modalProps, {
  defaultFullscreen: { type: Boolean },
  // Can it be full screen
  canFullscreen: { type: Boolean, default: true },
  // After enabling the wrapper, the bottom can be increased in height
  wrapperFooterOffset: { type: Number, default: 0 },
  // Warm reminder message
  helpMessage: [String, Array] as PropType<string | string[]>,
  // Whether to setting wrapper
  useWrapper: { type: Boolean, default: true },
  loading: { type: Boolean },
  loadingTip: { type: String },
  /**
   * @description: Show close button
   */
  showCancelBtn: { type: Boolean, default: true },
  /**
   * @description: Show confirmation button
   */
  showOkBtn: { type: Boolean, default: true },

  wrapperProps: Object as PropType<Partial<ModalWrapperProps>>,

  afterClose: Function as PropType<() => Promise<VueNode>>,

  bodyStyle: Object as PropType<CSSProperties>,

  closable: { type: Boolean, default: true },

  closeIcon: Object as PropType<VueNode>,

  confirmLoading: { type: Boolean },

  destroyOnClose: { type: Boolean, default: true },

  footer: Object as PropType<VueNode>,

  getContainer: Function as PropType<() => any>,

  mask: { type: Boolean, default: true },

  maskClosable: { type: Boolean, default: true },
  keyboard: { type: Boolean, default: true },

  maskStyle: Object as PropType<CSSProperties>,

  okType: { type: String, default: 'primary' },

  okButtonProps: Object as PropType<ButtonProps>,

  cancelButtonProps: Object as PropType<ButtonProps>,

  title: { type: String },

  open: { type: Boolean },

  width: { type: [String, Number] as PropType<string | number>, default: '40%' },

  wrapClassName: { type: String },

  zIndex: { type: Number },
})
