<template>
    <div>
        <h2>Test Page</h2>
        <h3>当前: {{info.name}}</h3>
        <button @click="updateState">修改状态</button>
        <button @click="updateState2">修改状态2</button>
    </div>
</template>

<script>
    import {reactive, ref, readonly} from 'vue';
    export default {
        setup(props, context) {
            const info = reactive({name: 'zhang ying'});
            const infoReadOnly = readonly(info);
            
            const updateState = () => {
                infoReadOnly.name = 'I want to update you!';
            };

            const updateState2 = () => {
                info.name = 'I want to update you!';
            };

            return {updateState, info, updateState2};
        },
    }
</script>

<style lang="scss" scoped>

</style>