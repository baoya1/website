var app = new Vue({
    el: '#app',
    data: {
        regularList: []
    },
    filters: {
        formatDate: function (val) {
            var padDate = function (va) {
                va = va < 10 ? '0' + va : va;
                return va
            }
            var value = new Date(val)
            var year = value.getFullYear()
            var month = padDate(value.getMonth() + 1)
            var day = padDate(value.getDate())
            return year + '-' + month + '-' + day

        },
        formatTime: function (val) {
            var padDate = function (va) {
                va = va < 10 ? '0' + va : va;
                return va
            }
            var value = new Date(val)
            var hour = padDate(value.getHours());
            var minutes = padDate(value.getMinutes())
            return hour + ':' + minutes

        }
    },
    methods: {
        findAll: function () {
            axios.get('/regular').then(function (response) {
                app.regularList = response.data

            })
        },
        add: function () {
            app.regularList.push({})
        },
        save: function () {
            axios.post('/regular').then(function (response) {
                app.regularList = response.data

            })
        },
        update: function () {
            axios.get('/regular').then(function (response) {
                app.regularList = response.data

            })
        },
        del: function (id) {
            axios.delete('/regular/'+id).then(function (response) {
                app.regularList = response.data

            })
        },
        findOne:function () {
            axios.get('/regular').then(function (response) {
                app.regularList = response.data

            })
        }


    },
    created: function () {
        this.findAll()
    }

})




