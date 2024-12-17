# dih-fair-common

## Introduction / Motivation

The Common repo contains code and GitHub workflows that:
 - Generate domain data classes and schemas based on OAS documents in `/Source/Schemas`
 - Compile and publish Nuget packages used by sub-repos
   - DIH.DihBaseline.Common - constants, general helpers for logging, JSON, tasks and Json
   - DIH.DihBaseline.Common.Services - providers that access resources such as Database, Messaging, Storage and Tables
   - DIH.DihBaseline.Domain - auto generated code and JSON Schemas
 - Build up Azure infrastructure that is shared across multiple sub-repos
 
 The Common repo also contains Bicep modules in `/Source/IaC/shared_modules` and used from sub-repos by including this repo in their pipeline.

## Technical Details

### Technologies and prerequisites

- [Azure](https://azure.microsoft.com/) - where the DIH solution is running
- [GitHub Workflows](https://docs.github.com/en/actions/writing-workflows) - where CI/CD process is running

#### Optional, for .net development
- [Visual Studio 2022 or newer](https://visualstudio.microsoft.com/vs/)

Please refer to the project's head repo's README.md for developer setup guidance and GitHub / Azure Subscription requirements.

#### Custom setup steps

Prepare the repo by executing the following steps:
1. Update the below OpenAPI Specification documents to reflect data object types handled on the Ingestion layer and service layer. If multiple Ingestion points exist, add OAS files as needed.
   - `/Source/Schemas/ingestion-oas.yml`
   - `/Source/Schemas/service-oas.yml`
2. Edit `/Source/Schemas/domain-objects.yml` and provide the correct list of data object type information.

If the Ingestion layer fetch data from an external source, use the OAS document for this source.

#### Steps to enable sub-repos

To enable sub-repos (Ingestion, Data.Raw, Data.Prepared, Service) to build, the following steps must be completed:
1. Run the GitHub workflow for this repo - this will ensure that Maven / Nuget packages become available and Azure resources are created
2. Merge changes into the main branch for this repo - sub-repos use this branch to locate shared Bicep modules
3. In sub-repos that is .net based, edit *.csproj files and set the Nuget package version that is created in step 1

When these steps are completed, sub-repos are at a stage where they can be customized and later deployed.


### .net / nuget projects

For an up-to-date view of referenced Nuget packages used in this repo, please refer to the project files' PackageReference section:

Application code projects:
- [DIH.Common](/Source/DIH.Common/DIH.Common.csproj) - code for nuget package DIH.DihBaseline.Common
- [DIH.Common.Services](/Source/DIH.Common.Services/DIH.Common.Services.csproj) - code for nuget package DIH.DihBaseline.Common.Services
- [DIH.Domain](/Source/DIH.Domain/DIH.Domain.csproj) - code for nuget package DIH.DihBaseline.Domain

Build tool code projects:
- [DomainNamingHelper](/Source/BuildTools/DomainNamingHelper/DomainNamingHelper.csproj)
- [OasSchemaExporter](/Source/BuildTools/OasSchemaExporter/OasSchemaExporter.csproj)

## Deployment

On GitHub execute the workflow ./.github/workflows/push-deploy.yml

## Responsible People

| Name | E-mail | Role |
| ---- | ------ | ---- |
| ... | [pm@redpilllinpro.com](mailto:pm@redpilllinpro.com) | Project manager |
| ... | [arc@redpilllinpro.com](mailto:arc@redpilllinpro.com) | Architect |
| ... | [dev@redpilllinpro.com](mailto:dev@redpilllinpro.com) | Developer |
| ... | [dev@redpilllinpro.com](mailto:dev@redpilllinpro.com) | Developer |


