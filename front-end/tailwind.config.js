/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ["./src/**/*.{html,ts}"],
    theme: {
        extend: {
            fontFamily: {
                ember: "Ember",
                bookerly: "Bookerly",
            },
        },
    },
    plugins: [],
};
