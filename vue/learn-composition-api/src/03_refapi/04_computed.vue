<template>
    <div>
        <h2>{{firstName}} {{lastName}}</h2>
        <h2>{{fullName}}</h2>
        <button @click="changeName">改变名称</button>
    </div>
</template>

<script>
    import {ref, computed} from 'vue';
    export default {
        setup() {
            const firstName = ref('kobe');
            const lastName = ref('bryant');

            // 直接传入getter函数
            // const fullName = computed(() => {
            //     return firstName.value + lastName.value;
            // });
            const fullName = computed({
                get: () => firstName.value + ' ' + lastName.value,
                set(newValue) {
                    const names = newValue.split(' ');
                    firstName.value = names[0];
                    lastName.value = names[1];
                }
            });

            

            const changeName = () => {
                fullName.value = 'zhang ying';
            }

            return {
                firstName, 
                lastName, 
                fullName, 
                changeName
            };
        }
    }
</script>

<style lang="scss" scoped>

</style>