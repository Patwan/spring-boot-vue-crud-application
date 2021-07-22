export const state = () => ({
    id: 0,
    name: "",
    email: "",
    password: ""
});


export const mutations = {
    storeId: (state, data) => {
        state.id = data
    },
    storename: (state, data) => {
        state.name = data
    },
    storeEmail: (state, data) => {
        state.email = data
    },
    storePassword: (state, data) => {
        state.password = data
    }
}