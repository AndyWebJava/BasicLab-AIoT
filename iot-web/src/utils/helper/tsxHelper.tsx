import type { Slots } from 'vue'
import { isFunction } from '@/utils/is'
import type { RenderOpts } from '@/components/Form'

/**
 * @description:  Get slot to prevent empty error
 */
export function getSlot(slots: Slots, slot = 'default', data?: any, opts?: RenderOpts) {
  if (!slots || !Reflect.has(slots, slot))
    return null

  if (!isFunction(slots[slot])) {
    console.error(`${slot} is not a function!`)
    return null
  }
  const slotFn = slots[slot]
  if (!slotFn)
    return null
  const params = { ...data, ...opts }
  return slotFn(params)
}

/**
 * extends slots
 * @param slots
 * @param excludeKeys
 */
export function extendSlots(slots: Slots, excludeKeys: string[] = []) {
  const slotKeys = Object.keys(slots)
  const ret: any = {}
  // eslint-disable-next-line array-callback-return
  slotKeys.map((key) => {
    if (excludeKeys.includes(key))
      return null

    ret[key] = (data?: any) => getSlot(slots, key, data)
  })
  return ret
}
