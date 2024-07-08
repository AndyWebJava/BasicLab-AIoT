import type { defineComponent } from 'vue'
import { Popover } from 'ant-design-vue'
import { h } from 'vue'
import type { ComponentType } from '../../types/componentType'
import { componentMap } from '@/components/Table/src/componentMap'

export interface ComponentProps {
  component: ComponentType
  rule: boolean
  popoverOpen: boolean
  ruleMessage: string
  getPopupContainer?: Fn
}

export function CellComponent({ component = 'Input', rule = true, ruleMessage, popoverOpen, getPopupContainer }: ComponentProps, { attrs }) {
  const Comp = componentMap.get(component) as typeof defineComponent

  const DefaultComp = h(Comp, attrs)
  if (!rule)
    return DefaultComp

  return h(
    Popover,
    {
      overlayClassName: 'edit-cell-rule-popover',
      open: !!popoverOpen,
      ...(getPopupContainer ? { getPopupContainer } : {}),
    },
    {
      default: () => DefaultComp,
      content: () => ruleMessage,
    },
  )
}
