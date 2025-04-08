// Inicialização do mapa
let map = L.map('map').setView([-23.5505, -46.6333], 13); // Posição inicial: São Paulo, SP
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

// Função para buscar a latitude e longitude a partir do nome da rua
function getLatLngFromAddress(address, callback) {
    const url = `https://nominatim.openstreetmap.org/search?q=${encodeURIComponent(address)}&format=json`;

    $.get(url, function(data) {
        if (data.length > 0) {
            const lat = data[0].lat;
            const lon = data[0].lon;
            callback(lat, lon);
        } else {
            alert("Endereço não encontrado!");
        }
    });
}

// Carregar a lista de motoboys
function carregarMotoboys() {
    $.get('/api/entregadores', function(data) {
        let motoboyList = $('#motoboyList');
        motoboyList.empty();

        data.forEach(function(motoboy) {
            motoboyList.append(`
                <li>
                    ${motoboy.nome} - <a href="#" class="viewRoute" data-id="${motoboy.id}">Visualizar Rota</a>
                </li>
            `);
        });
    });
}

// Exibir rota no mapa
function exibirRota(rota) {
    const pontos = rota.checkpoints.split(';').map(checkpoint => checkpoint.split(','));
    const latLngs = pontos.map(ponto => [parseFloat(ponto[0]), parseFloat(ponto[1])]);

    const polyline = L.polyline(latLngs, {color: 'blue'}).addTo(map);
    map.fitBounds(polyline.getBounds());
}

// Adicionar uma rota ao motoboy
function adicionarRota(motoboyId) {
    const pontoInicio = prompt("Digite o ponto de início (endereço):");
    const pontoFim = prompt("Digite o ponto de fim (endereço):");

    getLatLngFromAddress(pontoInicio, function(latInicio, lonInicio) {
        getLatLngFromAddress(pontoFim, function(latFim, lonFim) {
            const rota = {
                entregadorId: motoboyId,
                pontoInicio: pontoInicio,
                pontoFim: pontoFim,
                checkpoints: `${latInicio},${lonInicio};${latFim},${lonFim}`
            };

            $.post(`/api/rotas`, rota, function(response) {
                alert("Rota adicionada com sucesso!");
                carregarMotoboys(); // Recarregar a lista de motoboys
            });
        });
    });
}

// Evento para exibir as rotas dos motoboys
$(document).on('click', '.viewRoute', function() {
    const motoboyId = $(this).data('id');
    $.get(`/api/rotas/${motoboyId}`, function(rota) {
        exibirRota(rota);
    });
});

// Evento para adicionar rota
$('#addRouteBtn').click(function() {
    const motoboyId = prompt("Informe o ID do motoboy:");
    adicionarRota(motoboyId);
});

// Iniciar a página com a listagem dos motoboys
$(document).ready(function() {
    carregarMotoboys();
});
