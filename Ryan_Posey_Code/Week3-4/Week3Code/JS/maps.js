window.onload = function() {
    
    $('#homeNav').on('click', function() {
        $('#home').attr('hidden', false);
        $('#hash').attr('hidden', true);
        $('#tree').attr('hidden', true);
        $('#linked').attr('hidden', true);
        $('#furtherReading').attr('hidden', true);
    });
    $('#hashNav').on('click', function() {
        $('#home').attr('hidden', true);
        $('#hash').attr('hidden', false);
        $('#tree').attr('hidden', true);
        $('#linked').attr('hidden', true);
        $('#furtherReading').attr('hidden', true);
    });
    $('#treeNav').on('click', function() {
        $('#home').attr('hidden', true);
        $('#hash').attr('hidden', true);
        $('#tree').attr('hidden', false);
        $('#linked').attr('hidden', true);
        $('#furtherReading').attr('hidden', true);
    });
    $('#linkedNav').on('click', function() {
        $('#home').attr('hidden', true);
        $('#hash').attr('hidden', true);
        $('#tree').attr('hidden', true);
        $('#linked').attr('hidden', false);
        $('#furtherReading').attr('hidden', true);
    });
    $('#readNav').on('click', function() {
        $('#home').attr('hidden', true);
        $('#hash').attr('hidden', true);
        $('#tree').attr('hidden', true);
        $('#linked').attr('hidden', true);
        $('#furtherReading').attr('hidden', false);
    });
}