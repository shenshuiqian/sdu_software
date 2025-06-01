import {reqGetOrder, reqGetAllOrder, reqSearchOrder} from "../../api";

const state = {
    orders: [],
    filteredOrders: [],
}

const mutations = {
    updateOrder(state, orders) {
        state.orders = orders
    }
}

const actions = {
    getOrder({commit}, account) {
        reqGetOrder(account).then((data) => {
            const orders = []
            console.log(data)
            for (let items of data.orders) {
                const order = []
                for (let item of items) {
                    //console.log(item.cover);
                    const book = {
                        author: item.author,
                        name: item.book_name,
                        count: item.count,
                        price: item.price,
                        total: item.price*item.count,
                        cover: item.cover,
                        userName: item.user_name,
                        date: item.date
                     }
                     order.push(book)
                }
                orders.push(order)
            }
            commit('updateOrder', orders)
        })
    },

    getAllOrder({commit}) {
        reqGetAllOrder().then((data) => {
            const orders = []
            //console.log(data)
            for (let items of data.orders) {
                const order = []
                
                for (let item of items) {
                    //console.log('订单信息，',items)
                    //console.log(item.cover);
                    const book = {
                        author: item.author,
                        name: item.book_name,
                        count: item.count,
                        price: item.price,
                        total: item.price*item.count,
                        cover: item.cover,
                        //isbn: item.isbn,
                        userName: item.user_name,
                        date: item.date
                    }
                    order.push(book)
                }
                //console.log('订单信息，',order)
                orders.push(order)
            }
            //console.log('压入订单信息，',orders)
            commit('updateOrder', orders)
        })
    },

    searchOrder({commit}, filter) {
        reqSearchOrder(filter).then((data) => {
            const orders = []
            //console.log(data)
            for (let items of data.orders) {
                const order = []
                for (let item of items) {
                    const book = {
                        author: item.author,
                        name: item.book_name,
                        count: item.count,
                        price: item.price,
                        total: item.price*item.count,
                        cover: item.cover,
                        userName: item.user_name,
                        date: item.date
                    }
                    order.push(book)
                }
                orders.push(order)
            }
            commit('updateOrder', orders)
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}
