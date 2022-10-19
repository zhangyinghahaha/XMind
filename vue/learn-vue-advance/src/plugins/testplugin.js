export default {
    install(app) {
        console.log('test plugin');
        console.log(app);
        app.config.globalProperties.$name = 'zhang ying';
    }
};
