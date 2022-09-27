<template>
    <div>
        <h2>自定义指令</h2>
        <input type="text" ref="input">
    </div>
</template>

<script>
import { ref, onMounted } from 'vue'; 
export default {
    
    setup () {
        const input = ref(null);

        onMounted(() => {
            input.value.focus();
        });

        return {
            input
        }
    }
}
</script>

<style lang="scss" scoped>

</style>