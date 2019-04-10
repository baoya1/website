var vue = new Vue({
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
            var _this = this //this 表示vue对象
            axios.get('/regular').then(function (response) {
                //this变成了window
                _this.regularlist = response.data

            })
        },
        add: function () {
            var _this = this //this 表示vue对象
            axios.get('/regular').then(function (response) {
                //this变成了window
                _this.regularlist = response.data

            })
        },
        save: function () {
            var _this = this //this 表示vue对象
            axios.get('/regular').then(function (response) {
                //this变成了window
                _this.regularlist = response.data

            })
        },
        update: function () {
            var _this = this //this 表示vue对象
            axios.get('/regular').then(function (response) {
                //this变成了window
                _this.regularlist = response.data

            })
        },
        del: function () {
            var _this = this //this 表示vue对象
            axios.get('/regular').then(function (response) {
                //this变成了window
                _this.regularlist = response.data

            })
        }


    },
    created: function () {
        this.findAll()
    }

})




