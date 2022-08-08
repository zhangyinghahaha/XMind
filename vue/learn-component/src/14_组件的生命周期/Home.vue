<template>
    <div>
        <h2>{{message}}</h2>
        <button @click="changeMessage">修改message</button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                message: 'hello'
            }
        },
        methods: {
            changeMessage() {
                this.message = 'zhang ying';
            }
        },
        beforeCreate() {
            console.log('before create');
        },
        created() {
            console.log('created');
        },
        beforeMount() {
            console.log('before mount');
        },
        mounted() {
            console.log('mounted');
        },
        beforeUnmount() {
            console.log('before unmount');
        },
        unmounted() {
            console.log('unmounted');
        },
        beforeUpdate() {
            console.log('before update');
        },
        updated() {
            console.log('updated');
        }
    }
</script>

<style lang="scss" scoped>

</style>