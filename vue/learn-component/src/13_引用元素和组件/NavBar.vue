<template>
    <div>
        <h2>NavBar</h2>
        <button @click="getParentAndRoot">获取父组件和根组件</button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                message: '我是navbar'
            }
        },
        methods: {
            getParentAndRoot() {
                console.log(this.$parent.name);
                console.log(this.$root.name);
            }
        },
    }
</script>

<style lang="scss" scoped>

</style>