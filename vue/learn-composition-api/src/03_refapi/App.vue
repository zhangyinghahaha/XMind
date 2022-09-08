<template>
    <div>
        <h2>{{info.name}}-{{info.age}}</h2>
        <button @click="changeAge">修改age</button>

        <h2>{{name}}-{{age}}</h2>
        <button @click="changeAge2">修改age</button>
    </div>
</template>

<script>
    import {reactive, toRefs, toRef} from 'vue';
    export default {
        setup() {
            const info = reactive({
                name: "why",
                age: 18,
            });
            const changeAge = () => {
                info.age++
            };

            let {name, age} = toRefs(info);
            const changeAge2 = () => {
                age.value++;
                console.log(age);
            };

            let ageRef = toRef(info, "age");


            return {
                info, changeAge, name, age, changeAge2
            };
        }
    }
</script>

<style lang="scss" scoped>

</style>