var vue = new Vue({
    el: '#app',
    data: {
        fileList: []
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
            var hour = padDate(value.getHours());
            var minutes = padDate(value.getMinutes())
            var seconds = padDate(value.getSeconds())
            return year + '-' + month + '-' + day + ' ' + hour + ':' + minutes + ':' + seconds

        },
        formatSize: function (val) {
            var size = (val / 1024 / 1024).toFixed(2) + " MB"
            if (size.endsWith("0 MB")) {
                size = (val / 1024).toFixed(2) + " KB"
                if (size.endsWith("0 KB")) {
                    size = (val).toFixed(2) + " B"
                }
            }
            return size
        }
    },
    methods: {
        findAll: function () {
            var _this = this //this 表示vue对象
            axios.get('/upFile').then(function (response) {
                //this变成了window
                _this.fileList = response.data

            })
        }


    },
    created: function () {
        this.findAll()
    }

})




