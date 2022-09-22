<template>
    <div>
        <h2 ref="title">{{info.age}}</h2>
        <button @click="addAge">年龄+1</button>
    </div>
</template>

<script>
    import {ref, watch, watchEffect, reactive} from 'vue';
    export default {
        setup() {
            const info = reactive({
                name: 'why',
                age: 18
            });
            const name = ref('zhang ying');

            watch([info, name], (newValue, oldValue) => {
              console.log('new: ', newValue);
              console.log('old: ', oldValue);
              console.log(newValue === oldValue);
            });

            const addAge = () => {
                info.age++;
            };

            return {info,addAge};
        }
    }
</script>

<style lang="scss" scoped>

</style>