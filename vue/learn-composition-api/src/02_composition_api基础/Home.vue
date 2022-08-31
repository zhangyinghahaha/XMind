<template>
    <div>
        Home Page
        <h2>{{ message }}</h2>
        
        <h2>{{title}}</h2>
        <h2>{{counter}}</h2>
    </div>
</template>

<script>
    export default {
        props: {
            message: {
                type: String,
                required: true
            },
        },
        data() {
            return {
                counter: 0
            }
        },
        setup(props, context) {
            // setup里面不能使用this
            console.log(props.message);
            console.log(context.attrs);
            console.log(context.emit);

            return {
                title: "setup return message",
                counter: 100
            };
        }
    }
</script>

<style lang="scss" scoped>

</style>