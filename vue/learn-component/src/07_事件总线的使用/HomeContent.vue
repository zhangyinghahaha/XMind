<template>
    <div>
        
    </div>
</template>

<script>
import emitter from './utils/eventbus';
    export default {
        created () {
            emitter.on('about', () => {
                console.log('HomeContent Licenser');
            });
        },
    }
</script>

<style lang="scss" scoped>

</style>