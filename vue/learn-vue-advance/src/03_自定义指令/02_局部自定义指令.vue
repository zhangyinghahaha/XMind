<template>
    <div>
        <h2>自定义指令</h2>
        <input type="text" v-focus>

        <h2>当前计数: {{counter}}</h2>
        <button @click="increment">+1</button>
    </div>
</template>

<script>
import { ref, onMounted } from 'vue'; 
export default {
    directives: {
        focus: {
            mounted(element) {
                console.log('focus mounted');
                element.focus();
            }
        }
    },
    setup () {
        const counter = ref(0);
        const increment = () => counter.value++;

        return {
            counter,
            increment
        }
    }
}
</script>

<style lang="scss" scoped>

</style>