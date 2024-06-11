Claro, vou criar um `README.md` completo e bem formatado sem trechos de código inline.

### Estrutura do README.md

```markdown
# Easy Task Manager

Este projeto é um sistema de gestão de tarefas que inclui um backend desenvolvido com Spring Boot e um frontend móvel desenvolvido com Android (Kotlin).

## Estrutura do Repositório

```
your-repo-name/
├── backend/
│   ├── src/
│   ├── pom.xml
│   ├── ...
├── frontend/
│   ├── app/
│   ├── build.gradle
│   ├── ...
└── README.md
```

## Requisitos

- Java 11+
- Maven 3.6.3+
- Android Studio

## Configuração e Execução

### Backend

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/juliocelho88/EasyTask
   cd EasyTask/backend
   ```

2. **Execute o backend Spring Boot:**
   ```bash
   mvn spring-boot:run
   ```

3. **Verifique se o backend está funcionando:**
   - Abra um navegador e acesse `http://localhost:8080/h2-console` para visualizar o console do H2 Database.
   - Acesse `http://localhost:8080/api/tasks` para verificar a API.

### Frontend

1. **Abra o Android Studio:**
   - Selecione `File` > `Open...` e navegue até o diretório `frontend`.

2. **Configure o emulador ou conecte um dispositivo físico.**

3. **Execute a aplicação Android:**
   - Clique no botão `Run` ou use o atalho `Shift+F10`.

## Configurações Importantes

### Configuração de Segurança de Rede (Android)

Certifique-se de que o arquivo `network_security_config.xml` está presente em `frontend/app/src/main/res/xml/` com o seguinte conteúdo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">10.0.2.2</domain>
    </domain-config>
</network-security-config>
```

E que o `AndroidManifest.xml` está configurado para usar esta configuração de segurança de rede:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="br.com.fiap.easytask">

    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:networkSecurityConfig="@xml/network_security_config"
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.EasyTask"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/AppTheme">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## Funcionalidades

- **Backend:**
  - API RESTful para gerenciar tarefas (CRUD).
  - Persistência usando H2 Database.
  
- **Frontend:**
  - Interface de usuário para visualizar, adicionar, editar e excluir tarefas.
  - Comunicação com o backend via Retrofit.

## Contribuindo

Se você quiser contribuir com este projeto, por favor, siga os passos abaixo:

1. Fork o repositório.
2. Crie uma nova branch (`git checkout -b feature/nome-da-feature`).
3. Faça suas alterações e commit (`git commit -am 'Adicionei uma nova feature'`).
4. Envie para o branch (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.



