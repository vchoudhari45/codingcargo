module.exports = {
  purge: {
    //https://tailwindcss.com/docs/controlling-file-size/
    //enabled: true,
    content: [
      "./src/pages/**/*.js",
      "./src/pages/**/*.jsx",
      "./src/pages/**/*.ts",
      "./src/pages/**/*.tsx",
      
      "./src/pages/*.js",
      "./src/pages/*.jsx",
      "./src/pages/*.ts",
      "./src/pages/*.tsx",

      "./src/component/**/*.js",
      "./src/component/**/*.jsx",
      "./src/component/**/*.ts",
      "./src/component/**/*.tsx",

      "./src/component/*.js",
      "./src/component/*.jsx",
      "./src/component/*.ts",
      "./src/component/*.tsx",
    ]
  },
  theme: {
    extend: {},
  },
  variants: {},
  plugins: [
    'autoprefixer',
    [
      '@fullhuman/postcss-purgecss',
      {
        content: [
          './src/pages/**/*.{js,jsx,ts,tsx}',
          './src/components/**/*.{js,jsx,ts,tsx}',
        ],
        defaultExtractor: (content) => content.match(/[\w-/:]+(?<!:)/g) || [],
      }
    ]
  ],
}
