package br.com.awesomehello.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.github.osvaldjr.domains.AlertRisk;
import io.github.osvaldjr.domains.DataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.zaproxy.clientapi.core.ClientApiException;

import java.io.IOException;
import java.util.List;

public class SecuritySteps {

    @Autowired
    private io.github.osvaldjr.stepdefinitions.steps.SecuritySteps securitySteps;

    @Dado("Eu importo o contexto da especificacao da API {string}")
    public void euImportoOContextoDaEspecificacaoDaAPI(final String path) throws InterruptedException,
            ClientApiException {
        securitySteps.iImportContextFromOpenAPISpecification(path);
    }

    @E("Eu removo os alertas")
    public void euRemovoOsAlertas(final List<DataType> data) throws ClientApiException {
        securitySteps.iRemoveAlert(data);
    }

    @E("Eu importo as politicas de varredura")
    public void euImportoAsPoliticasDeVarredura() throws ClientApiException {
        securitySteps.iImportScanPolicyFromFile("security", "security.policy");
    }

    @Quando("Eu executo a varredura ativa")
    public void euExecutoAVarreduraAtiva() throws InterruptedException, ClientApiException, IOException {
        securitySteps.iRunActiveScan();
        securitySteps.iGenerateSecurityTestHTMLReportWithName("security-report");
    }

    @Entao("o numero de riscos por categoria nao deve ser maior que")
    public void oNumeroDeRiscosPorCategoriaNaoDeveSerMaiorQue(final List<AlertRisk> risks) throws ClientApiException {
        securitySteps.theNumberOfRisksPerCategoryShouldNotBeGreaterThan(risks);
    }
}
