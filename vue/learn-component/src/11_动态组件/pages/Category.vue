<template>
    <div>
        Category组件
        <button @click="counter++">{{counter}}</button>
    </div>
</template>

<script>
    export default {
        name: 'category',
        data() {
            return {
                counter: 0
            }
        },
    }
</script>

<style lang="scss" scoped>

</style>