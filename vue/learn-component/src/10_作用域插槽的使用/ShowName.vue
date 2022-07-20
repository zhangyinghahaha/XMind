<template>
    <div>
        <div v-for="item in names" :key="item">
            <slot :item="item"></slot>
        </div>
    </div>
</template>

<script>
    export default {
        props: {
            names: {
                type: Array,
                default: () => []
            },
        },
    }
</script>

<style lang="scss" scoped>

</style>