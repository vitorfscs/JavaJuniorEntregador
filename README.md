# 🚚 JavaJuniorEntregador

Sistema de entregas simples e funcional com listagem de entregadores, criação de rotas e visualização geográfica usando **Java + Spring Boot**, **Lombok**, **Firebase**, **jQuery** e **OpenStreetMap**.

---

## 🧾 Sobre a Aplicação

O **JavaJuniorEntregador** é um sistema de gestão de entregas desenvolvido como projeto prático para aplicar conhecimentos em backend e frontend. Ele permite:

- 📋 **Cadastro e listagem de entregadores**
- 🗺️ **Criação de rotas de entrega**
- 📍 **Visualização de rotas no mapa com integração via OpenStreetMap**
- 🔄 **Persistência de dados com PostgreSQL e Firebase**

---

## 🧰 Tecnologias Utilizadas

| Tecnologia      | Descrição |
|-----------------|-----------|
| **Java + Spring Boot** | Backend robusto e rápido de desenvolver. Tenho afinidade, fiz bootcamp há 6 meses e venho estudando desde então. |
| **Lombok**       | Simplifica a escrita de classes Java, evitando repetição de código. |
| **PostgreSQL**   | Banco de dados relacional usado para armazenar entregadores e rotas. |
| **Firebase**     | Usado para armazenamento em tempo real e integração com frontend. |
| **jQuery**       | Manipulação rápida do DOM. JavaScript foi minha primeira linguagem, então ficou fácil integrar com jQuery. |
| **OpenStreetMap API** | Integração para visualização das rotas no mapa. |
| **ChatGPT 4.0**  | Utilizei para revisar e corrigir pequenos erros, mas 70% do código foi escrito por mim, com domínio total do projeto. |

---

## 📌 Funcionalidades

### ✅ Entregadores
- Cadastro
- Edição
- Listagem
- Exclusão

### 📦 Rotas de Entrega
- Criação de nova rota
- Listagem de todas as rotas criadas
- Associação de entregadores à rota
- Visualização em tempo real da rota no mapa

### 🗺️ Mapa (OpenStreetMap)
- Visualização interativa das rotas
- Marcadores com pontos de entrega
- Interface dinâmica com feedback visual

---

## 🛠️ Como Rodar o Projeto Localmente

### 1. Clonar o Repositório

```bash
git clone https://github.com/vitorfscs/JavaJuniorEntregador.git
cd JavaJuniorEntregador
2. Configurar o PostgreSQL
Crie um banco de dados chamado Artorias.

Atualize application.properties:

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/Artorias
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
3. Configurar o Firebase
Acesse: https://console.firebase.google.com/

Crie um projeto.

Baixe o serviceAccountKey.json e coloque em:
backend/src/main/resources/

No application.properties, adicione:

properties
Copiar
Editar
firebase.database.url=https://SEU_PROJETO.firebaseio.com
4. Rodar o Backend
bash
Copiar
Editar
cd backend
./mvnw spring-boot:run
5. Rodar o Frontend
Abra o arquivo index.html no navegador, ou use extensão Live Server no VSCode.

🧠 Observações
A API do OpenStreetMap foi integrada manualmente com jQuery para exibir rotas com precisão.

Utilizei Firebase para sincronização e backup de dados rápidos.

O projeto foi idealizado como sistema de entregas para pequenas e médias empresas, podendo ser expandido com login, autenticação JWT, painel administrativo e mais.

📷 Prints
Imagens da aplicação em funcionamento estão disponíveis na pasta /PRINTS.

✍️ Autor
Vitor F.
Desenvolvedor Backend com conhecimentos sólidos em Spring Boot e QA.
Focado em criar soluções reais, escaláveis e eficientes.

💬 Agradecimentos
Obrigado à comunidade que me ajudou, aos conteúdos do bootcamp e também ao ChatGPT 4.0, que foi uma ferramenta de apoio durante o desenvolvimento.

“Aprender nunca é demais. Cada projeto é uma nova escada para o sucesso.”

arduino
Copiar
Editar
