// On production, variables are set with `now secrets`. On development, they use the .env file
require('dotenv').config();
module.exports = {
  //https://nextjs.org/docs/api-reference/next.config.js/exportPathMap
  //https://nextjs.org/docs/advanced-features/static-html-export
  exportPathMap: async function (defaultPathMap, { dev, dir, outDir, distDir, buildId }) {
    console.log(defaultPathMap)
    console.log(dev)
    console.log(dir)
    console.log(outDir)
    console.log(distDir)
    console.log(buildId)
    return {
          "/" : { page: '/' },
          "/index" : { page: '/index' },
          "/404" : { page: '/404' },
          "/list/data-structures-and-algorithms" : { page: '/list/[category]' },
          "/list/home" : { page: '/list/[category]' },
          "/list/data-structures-and-algorithms/array" : { page: '/list/[category]/[tag]' },
          "/list/data-structures-and-algorithms/array/1" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/array/2" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/array/3" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/array/4" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/array/5" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/array/6" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/array/7" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table" : { page: '/list/[category]/[tag]' },
          "/list/data-structures-and-algorithms/hash-table/1" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table/2" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table/3" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table/4" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table/5" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table/6" : { page: '/list/[category]/[tag]/[page]' },
          "/list/data-structures-and-algorithms/hash-table/7" : { page: '/list/[category]/[tag]/[page]' },
          "/post/two-sum" : { page: '/post/[postTitle]' },
          "/post/two-sum1" : { page: '/post/[postTitle]' },
          "/post/two-sum2" : { page: '/post/[postTitle]' },
          "/post/two-sum3" : { page: '/post/[postTitle]' },
          "/post/two-sum4" : { page: '/post/[postTitle]' },
          "/post/two-sum5" : { page: '/post/[postTitle]' },
          "/post/two-sum6" : { page: '/post/[postTitle]' },
          "/post/two-sum7" : { page: '/post/[postTitle]' },
    }
  },
  compress: true,
  exportTrailingSlash: true,
  env: {
    FIREBASE_API_KEY: process.env.FIREBASE_API_KEY,
    FIREBASE_AUTH_DOMAIN: process.env.FIREBASE_AUTH_DOMAIN,
    FIREBASE_DATABASE_URL: process.env.FIREBASE_DATABASE_URL,
    FIREBASE_PROJECT_ID: process.env.FIREBASE_PROJECT_ID,
    FIREBASE_STORAGE_BUCKET: process.env.FIREBASE_STORAGE_BUCKET,
    FIREBASE_MESSAGING_SENDER_ID: process.env.FIREBASE_MESSAGING_SENDER_ID,
    FIREBASE_APP_ID: process.env.FIREBASE_APP_ID,
    FIREBASE_MEASUREMENT_ID: process.env.FIREBASE_MEASUREMENT_ID
  },
  devIndicators: {
    autoPrerender: false,
  }
}
