import { wrapFunctional } from './utils'

export { default as Form } from '../..\\components\\Form.vue'
export { default as Table } from '../..\\components\\Table.vue'

export const LazyForm = import('../..\\components\\Form.vue' /* webpackChunkName: "components/form" */).then(c => wrapFunctional(c.default || c))
export const LazyTable = import('../..\\components\\Table.vue' /* webpackChunkName: "components/table" */).then(c => wrapFunctional(c.default || c))
