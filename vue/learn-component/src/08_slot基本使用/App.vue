<template>
    <div>
        <MySlot>
            <button>我是按钮</button>
            <p>hello, slot</p>
            <p>{{name}}</p>
        </MySlot>

        <MySlot></MySlot>
    </div>
</template>

<script>
import MySlot from './MySlot.vue';
    export default {
    components: { MySlot },
    data() {
        return {
            name: 'App.vue'
        }
    },
}
</script>

<style lang="scss" scoped>

</style>