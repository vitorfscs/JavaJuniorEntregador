# JavaJuniorEntregador

Projeto desenvolvido para gerenciar serviços de entrega utilizando Java com Spring Boot, Lombok e jQuery.

## 📁 Estrutura de Pastas

- `backend`: Código-fonte da aplicação backend com Spring Boot.
- `.vscode`: Configurações do editor Visual Studio Code.
- `PRINTS`: Imagens e capturas de tela do projeto.

## 🚀 Tecnologias Utilizadas

- **Spring Boot**: Escolhi essa tecnologia porque tenho afinidade. Fiz um bootcamp há 6 meses e, desde então, venho me aperfeiçoando constantemente.
- **Lombok**: Utilizado para reduzir a verbosidade no código Java, evitando a necessidade de escrever manualmente getters, setters, construtores, etc.
- **jQuery**: Apesar de ter recebido ajuda para algumas partes, o JavaScript foi a primeira linguagem que aprendi, o que facilitou bastante a integração com jQuery.

> ⚙️ Para corrigir erros no desenvolvimento, utilizei o ChatGPT 4.0. Tenho experiência no uso dessa ferramenta para resolver problemas rapidamente, mas 70% do código foi escrito por mim manualmente.

---

## 🛠️ Como Rodar o Projeto Localmente

### 1. Clonar o Repositório

```bash
git clone https://github.com/vitorfscs/JavaJuniorEntregador.git
cd JavaJuniorEntregador
2. Configurar o Banco de Dados PostgreSQL
Crie um banco chamado Artorias no PostgreSQL.

Atualize o arquivo application.properties com seu usuário e senha:

properties
Copiar
Editar
# backend/src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Artorias
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Configurar o Firebase
Crie um projeto no Firebase Console.

Gere o arquivo serviceAccountKey.json e coloque dentro de backend/src/main/resources/.

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
Abra o arquivo index.html (na raiz do projeto) diretamente no navegador:

bash
Copiar
Editar
start index.html
Ou, se preferir, use uma extensão Live Server no VSCode para facilitar o desenvolvimento.

📸 Prints
A pasta PRINTS/ contém algumas capturas de tela e exemplos visuais da aplicação em funcionamento.

✍️ Autor
Vitor F. - Desenvolvedor Backend com conhecimento em QA e entusiasta de tecnologias modernas.

🧠 Curiosidade
Este projeto foi feito com dedicação, misturando aprendizado prático com recursos modernos como o ChatGPT 4.0. Ele me ajudou em partes específicas, mas a lógica e estrutura foram fruto do meu esforço pessoal.
