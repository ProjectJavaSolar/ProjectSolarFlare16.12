let funFacts = [];

$(function () {
    $('.funFacts li').each(function(i)
    {
        funFacts.push($(this).text());
    });

    $('.funFacts').remove();
});

$('.randomFactButton').click(function () {
    $('.randomFact').text(getRandomFact(funFacts));
});

function getRandomFact(funFacts) {
    let randomIndex = Math.floor(Math.random()*funFacts.length);

    return funFacts[randomIndex];
}