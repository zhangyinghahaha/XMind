<template>
    <div>
        <h2>{{name}} {{age}}</h2>
        <button @click="changeName">修改Name</button>
        <button @click="changeAge">修改Age</button>
    </div>
</template>

<script>
    import {ref, watch, watchEffect} from 'vue';
    export default {
        setup() {
            const name = ref('zhang');
            const age = ref(18);

            const changeName = () => {
                name.value = 'ying';
            };
            

            // 自动收集响应式的数据
            const stopWatch = watchEffect(() => {
                console.log('name:', name.value);
                console.log('age:', age.value);
            });
            const changeAge = () => {
                age.value++;
                if (age.value > 25) {
                    stopWatch();
                }
            };

            return {
                name,
                age,
                changeName,
                changeAge,
            };
        }
    }
</script>

<style lang="scss" scoped>

</style>