<template>
    <div>
        <slot>{{name}}</slot>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                name: 'ChildCpn.vue'
            }
        },
    }
</script>

<style lang="scss" scoped>

</style>