<template>
    <div>
        <h2>{{info}}</h2>
        <button @click="changeInfo">修改Info</button>
        <button @click="changeInfo2">修改Info2</button>
    </div>
</template>

<script>
    import {ref, shallowRef} from 'vue';
    export default {
        setup() {
            // const info = ref({name: 'zhang'});
            const info = shallowRef({name: 'zhang'})

            const changeInfo = () => {
                info.value.name = 'ying';
            }

            const changeInfo2 = () => {
                info.value = {name: 'shallowRef'};
            }

            return {info, changeInfo, changeInfo2};
        }
    }
</script>

<style lang="scss" scoped>

</style>