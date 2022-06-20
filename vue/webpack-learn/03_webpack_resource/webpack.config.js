const path = require('path');

module.exports = {
    entry: './src/main.js',
    output: {
        path: path.resolve(__dirname, './build'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                // loader: 'css-loader'
                use: [
                    'style-loader',
                    'css-loader', 
                    {
                        loader: 'postcss-loader',
                        options: {
                            postcssOptions: {
                                plugins: [require('postcss-preset-env')]
                            }
                        }
                    }
                ]
            },
            {
                test: /\.less$/,
                // loader: 'css-loader'
                use: [
                    'style-loader',
                    'css-loader', 
                    'less-loader',
                ]
            },
            // {
            //     test: /\.(jpg|jpeg|png|gif|svg)$/,
            //     use: {
            //         loader: 'url-loader',
            //         options: {
            //             // outputPath: 'img',
            //             name: 'img/[name]_[hash:6].[ext]',
            //             limit: 100*1024
            //         }
            //     },
            // },
            {
                test: /\.(jpg|jpeg|png|gif|svg)$/,
                type: 'asset',
                generator: {
                    filename: 'image/[name]_[hash:6][ext]',
                },
                parser: {
                    dataUrlCondition: {
                        maxSize: 100*1024
                    }
                },
            }
        ],
    }
}