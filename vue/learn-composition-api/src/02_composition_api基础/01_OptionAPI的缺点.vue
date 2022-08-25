<template>
    <div>
        <h2>{{counter}}</h2>
        <h2>Counter * 2: {{doubleCounter}}</h2>
        <button>+1</button>
        <button>-1</button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                counter: 0,
            }
        },
        methods: {
            increment() {
                
            }
        },
        computed: {
            doubleCounter() {
                return this.counter * 2 
            }
        },
    }
</script>

<style lang="scss" scoped>

</style>