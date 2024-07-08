import impExcel from './src/ImportExcel.vue'
import expExcelModal from './src/ExportExcelModal.vue'
import { withInstall } from '@/utils'

export const ImpExcel = withInstall(impExcel)
export const ExpExcelModal = withInstall(expExcelModal)
export * from './src/typing'
export { jsonToSheetXlsx, aoaToSheetXlsx } from './src/Export2Excel'
