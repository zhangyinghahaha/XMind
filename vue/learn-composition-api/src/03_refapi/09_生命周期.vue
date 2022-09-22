<template>
    <div>
        <h2>App</h2>
        <button @click="increment">{{counter}}</button>
    </div>
</template>

<script>
    import {onMounted, onUnmounted, onUpdated, ref} from 'vue';
    export default {
        setup() {
            onMounted(() => {
                console.log('App Mounted.');
            });
            onMounted(() => {
                console.log('App Mounted2.');
            });
            onUnmounted(() => {
               console.log('App Unmounted.'); 
            });
            onUpdated(() => {
               console.log('App Updated.'); 
            });

            const counter = ref(0);
            const increment = () => {
                counter.value++;
            };

            return {
                counter,
                increment
            };
        }
    }
</script>

<style lang="scss" scoped>

</style>