drop schema if exists material cascade;
drop schema if exists core cascade;
drop schema if exists manufacture cascade;
drop schema if exists financial cascade;
drop schema if exists survey cascade;
drop schema if exists bank cascade;
drop schema if exists creditcard cascade;
drop schema if exists legacy cascade;
create schema core;
create schema material;
create schema manufacture;
create schema financial;
create schema survey;
create schema bank;
create schema creditcard;
create schema legacy;

---------------------

insert into core.tb_city(ci_city, nm_city, fl_uf)values(2304400, 'FORTALEZA', 'CE');
insert into core.tb_city(ci_city, nm_city, fl_uf)values(2309999, 'EUSÉBIO', 'CE');
insert into core.tb_city(ci_city, nm_city, fl_uf)values(4105500, 'SINOP', 'MT');
insert into core.tb_city(ci_city, nm_city, fl_uf)values(4101111, 'SORRISO', 'MT');
insert into core.tb_person(ci_person, nm_person, ds_email, cd_city, fl_type, dt_birth)values(1, 'ADMINISTRADOR DO SISTEMA', 'admin@teslaerp.com.br', 2304400, 'FISICA', '2016-01-01');
insert into core.tb_user(ci_user, fl_active, fl_enabled, ds_login, ds_password)values(1, true, true, 'admin', md5('123'));
insert into core.tb_person(ci_person, nm_person, ds_email, cd_city, fl_type, dt_birth)values(2, 'TESLA INDÚSTRIA LTDA', '', 2304400, 'JURIDICA', '2016-01-01');
insert into core.tb_workgroup(ci_workgroup, fl_workgroup_type, fl_enabled)values(2, 'HEAD_OFFICE', true);
insert into core.tb_person(ci_person, nm_person, nm_fantasy, ds_email, cd_city, fl_type, dt_birth)values(3, 'VIDEOMAR REDE NORDESTE S/A', 'MULTIPLAY', '', 2304400, 'JURIDICA', '2016-01-01');
insert into core.tb_provider(ci_provider, nm_contact, ds_status, fl_enabled)values(3, 'JOSIMAR', 'BOM', true);
insert into core.tb_person(ci_person, nm_person, nm_fantasy, ds_email, cd_city, fl_type, dt_birth)
values(4, 'MARLENA CATUNDA INDÚSTRIA DE CONFECÇÕES LTDA', 'ANGELIQUE', '', 2304400, 'JURIDICA', '2016-01-01');
insert into core.tb_customer(ci_customer, ds_status, nr_credit_limit, fl_enabled)
values(4, 'BOM', 60000, true);
----------------------------
insert into core.tb_module(nm_module)values('Core');
insert into core.tb_resource(nm_resource,cd_module)values('Pessoa',1);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Listagem de Pessoas','PERSON',1);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Consulta Detalhada de Pessoas','PERSON_DETAIL',1);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Manutenção de Pessoas','PERSON_SAVE',1);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Relatório Detalhado de Pessoas','PERSON_REPORT',1);

insert into core.tb_resource(nm_resource,cd_module)values('Acesso',1);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Listagem de Grupo de Acesso','GROUP',2);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Cadastro de Grupo de Acesso','GROUP_SAVE',2);
insert into core.tb_transaction(nm_transaction,nm_label,cd_resource)values('Cadastro de Transações por Grupo de Acesso','GROUP_TRANSACTION',2);    

insert into core.tb_resource(nm_resource,cd_module)values('Unidade de Trabalho',1);
insert into core.tb_module(nm_module)values('Financeiro');
insert into core.tb_module(nm_module)values('Materiais');
insert into core.tb_module(nm_module)values('Manufatura');
insert into core.tb_module(nm_module)values('Comercial');

insert into core.tb_group(nm_group)values('Administração');
insert into core.tb_group_transaction(cd_group,cd_transaction)values(1,1);
insert into core.tb_user_group(cd_group,cd_user) values(1,1);
insert into core.tb_user_transaction(cd_user,cd_transaction)values(1,2);
insert into core.tb_user_transaction(cd_user,cd_transaction)values(1,3);

-------------Bancos----------
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(1,'Banco do Brasil S.A.','00.000.000/0001-91','www.bb.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(3,'Banco da Amazônia S.A.','04.902.979/0001-44','www.bancoamazonia.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(4,'Banco do Nordeste do Brasil S.A.','07.237.373/0001-20','www.banconordeste.gov.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(12,'Banco Standard de Investimentos S.A.','04.866.275/0001-63','www.standardtb_banco.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(14,'Natixis Brasil S.A. Banco Múltiplo','9.274.232','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(18,'Banco Tricury S.A.','57.839.805/0001-40','www.tricury.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(19,'Banco Azteca do Brasil S.A.','9.391.857','www.bancoazteca.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(21,'BANESTES S.A. Banco do Estado do Espírito Santo','28.127.603/0001-78','www.banestes.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(24,'Banco BANDEPE S.A.','10.866.788/0001-77','www.bandepe.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(25,'Banco Alfa S.A.','03.323.840/0001-83','www.bancoalfa.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(29,'Banco Banerj S.A.','33.885.724/0001-19','www.banerj.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(31,'Banco Beg S.A.','01.540.541/0001-75','www.itau.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(33,'Banco Santander (Brasil) S.A.','90.400.888/0001-42','www.santander.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(36,'Banco Bradesco BBI S.A.','06.271.464/0001-19','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(37,'Banco do Estado do Pará S.A.','04.913.711/0001-08','www.banparanet.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(39,'Banco do Estado do Piauí S.A. - BEP','06.833.131/0001-36','www.bep.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(40,'Banco Cargill S.A.','03.609.817/0001-50','www.bancocargill.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(41,'Banco do Estado do Rio Grande do Sul S.A.','92.702.067/0001-96','www.banrisul.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(44,'Banco BVA S.A.','32.254.138/0001-03','www.bancobva.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(45,'Banco Opportunity S.A.','33.857.830/0001-99','www.opportunity.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(47,'Banco do Estado de Sergipe S.A.','13.009.717/0001-46','www.banese.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(62,'Hipercard Banco Múltiplo S.A.','03.012.230/0001-69','www.hipercard.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(63,'Banco Ibi S.A. Banco Múltiplo','04.184.779/0001-01','www.ibi.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(64,'Goldman Sachs do Brasil Banco Múltiplo S.A.','04.332.281/0001-30','www.goldmansachs.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(65,'Banco AndBank (Brasil) S.A.','48.795.256/0001-69','www.bancobracce.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(66,'Banco Morgan Stanley S.A.','2.801.938','www.morganstanley.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(69,'BPN Brasil Banco Múltiplo S.A.','61.033.106','www.bpnbrasil.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(70,'BRB - Banco de Brasília S.A.','00.000.208/0001-00','www.brb.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(72,'Banco Rural Mais S.A.','33.074.683/0001-80','www.rural.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(73,'BB Banco Popular do Brasil S.A.','6.043.056','www.bancopopulardobrasil.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(74,'Banco J. Safra S.A.','03.017.677/0001-20','www.jsafra.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(75,'Banco ABN AMRO S.A.','03.532.415/0001-02','www.bancocr2.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(76,'Banco KDB S.A.','7.656.500','www.bancokdb.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(77,'Banco Intermedium S.A.','00.416.968','www.intermedium.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(78,'BES Investimento do Brasil S.A.-Banco de Investimento','34.111.187','www.besinvestimento.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(79,'Banco Original do Agronegócio S.A.','09.516.419/0001-75','www.bancooriginal.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(95,'Banco Confidence de Câmbio S.A.','11.703.662/0001-44','www.bancoconfidence.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(96,'Banco BM&FBOVESPA de Serviços de Liquidação e Custódia S.A','00.997.185','www.bmf.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(104,'Caixa Econômica Federal','00.360.305/0001-04','www.caixa.gov.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(107,'Banco BBM S.A.','15.114.366/0001-69','www.bbmtb_banco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(119,'Banco Western Union do Brasil S.A.','13.720.915','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(125,'Brasil Plural S.A. - Banco Múltiplo','45.246.410','www.brasilplural.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(136,'CONFEDERACAO NACIONAL DAS COOPERATIVAS CENTRAIS UNICREDS','00.315.557/0001-11','http://www.unicred.com.br/');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(168,'HSBC Finance (Brasil) S.A. - Banco Múltiplo','33.254.319','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(184,'Banco Itaú BBA S.A.','17.298.092/0001-30','www.itaubba.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(204,'Banco Bradesco Cartões S.A.','59.438.325/0001-01','www.iamex.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(208,'Banco BTG Pactual S.A.','30.306.294/0001-45','www.pactual.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(212,'Banco Original S.A.','92.894.922/0001-08','www.bancooriginal.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(213,'Banco Arbi S.A.','54.403.563/0001-50','www.arbi.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(214,'Banco Dibens S.A.','61.199.881/0001-06','www.bancodibens.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(215,'Banco Comercial e de Investimento Sudameris S.A.','61.230.165/0001-44','www.sudameris.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(217,'Banco John Deere S.A.','91.884.981/0001-32','www.johndeere.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(218,'Banco Bonsucesso S.A.','71.027.866/0001-34','www.bancobonsucesso.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(222,'Banco Credit Agricole Brasil S.A.','75.647.891/0001-71','www.calyon.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(224,'Banco Fibra S.A.','58.616.418/0001-08','www.bancofibra.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(225,'Banco Brascan S.A.','33.923.111/0001-29','www.bancobrascan.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(229,'Banco Cruzeiro do Sul S.A.','62.136.254/0001-99','www.bcsul.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(230,'Unicard Banco Múltiplo S.A.','61.071.387/0001-61','www.unicard.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(233,'Banco Cifra S.A.','62.421.979/0001-29','www.bancocifra.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(237,'Banco Bradesco S.A.','60.746.948/0001-12','www.bradesco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(241,'Banco Clássico S.A.','31.597.552/0001-52','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(243,'Banco Máxima S.A.','33.923.798','www.bancomaxima.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(246,'Banco ABC Brasil S.A.','28.195.667/0001-06','www.abcbrasil.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(248,'Banco Boavista Interatlântico S.A.','33.485.541/0001-06','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(249,'Banco Investcred Unibanco S.A.','61.182.408/0001-16','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(250,'BCV - Banco de Crédito e Varejo S.A.','50.585.090/0001-06','www.bancobcv.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(254,'Paraná Banco S.A.','14.388.334/0001-99','www.paranabanco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(263,'Banco Cacique S.A.','33.349.358/0001-83','www.bancocacique.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(265,'Banco Fator S.A.','33.644.196/0001-06','www.bancofator.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(266,'Banco Cédula S.A.','33.132.044/0001-24','www.bancocedula.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(300,'Banco de La Nacion Argentina','33.042.151/0001-61','www.bna.com.ar');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(318,'Banco BMG S.A.','61.186.680/0001-74','www.bancobmg.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(320,'Banco Industrial e Comercial S.A.','07.450.604/0001-89','www.bicbanco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(341,'Itaú Unibanco S.A.','60.701.190/0001-04','www.itau.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(356,'Banco Real S.A.','33.066.408/0001-15','www.bancoreal.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(366,'Banco Société Générale Brasil S.A.','61.533.584/0001-55','www.sgbrasil.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(370,'Banco Mizuho do Brasil S.A.','61.088.183/0001-33','www.mizuhotb_banco.com/brazil/pt/');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(376,'Banco J. P. Morgan S.A.','33.172.537/0001-98','www.jpmorgan.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(389,'Banco Mercantil do Brasil S.A.','17.184.037/0001-10','www.mercantil.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(394,'Banco Bradesco Financiamentos S.A.','07.207.996/0001-50','www.bmc.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(399,'HSBC Bank Brasil S.A. - Banco Múltiplo','01.701.201/0001-89','www.hsbc.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(409,'UNIBANCO - União de Bancos Brasileiros S.A.','33.700.394/0001-40','www.unibanco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(412,'Banco Capital S.A.','15.173.776/0001-80','www.bancocapital.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(422,'Banco Safra S.A.','58.160.789/0001-28','www.safra.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(453,'Banco Rural S.A.','33.124.959/0001-98','www.rural.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(456,'Banco de Tokyo-Mitsubishi UFJ Brasil S.A.','60.498.557/0001-26','www.btm.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(464,'Banco Sumitomo Mitsui Brasileiro S.A.','60.518.222/0001-22','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(473,'Banco Caixa Geral - Brasil S.A.','33.466.988','www.bcgbrasil.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(477,'CitiBank S.A.','33.042.953/0001-00','www.cititb_banco.com/brasil');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(479,'Banco ItaúBank S.A','60.394.079/0001-04','www.itautb_banco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(487,'Deutsche Bank S.A. - Banco Alemão','62.331.228/0001-11','www.deutsche-tb_banco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(488,'JPMorgan Chase Bank','46.518.205/0001-64','www.jpmorganchase.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(492,'ING Bank N.V.','49.336.860/0001-90','www.ing.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(494,'Banco de La Republica Oriental del Uruguay','51.938.876/0001-14','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(495,'Banco de La Provincia de Buenos Aires','44.189.447/0001-26','www.bapro.com.ar');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(505,'Banco Credit Suisse (Brasil) S.A.','32.062.580/0001-38','www.csfb.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(600,'Banco Luso Brasileiro S.A.','59.118.133/0001-00','www.lusobrasileiro.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(604,'Banco Industrial do Brasil S.A.','31.895.683/0001-16','www.bancoindustrial.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(610,'Banco VR S.A.','78.626.983/0001-63','www.vr.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(611,'Banco Paulista S.A.','61.820.817/0001-09','www.bancopaulista.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(612,'Banco Guanabara S.A.','31.880.826/0001-16','www.bancoguanabara.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(613,'Banco Pecúnia S.A.','60.850.229/0001-47','www.bancopecunia.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(623,'Banco PAN S.A.','59.285.411/0001-13','www.bancopan.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(626,'Banco Ficsa S.A.','61.348.538/0001-86','www.ficsa.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(630,'Banco Intercap S.A.','58.497.702/0001-02','www.intercap.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(633,'Banco Rendimento S.A.','68.900.810/0001-38','www.rendimento.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(634,'Banco Triângulo S.A.','17.351.180/0001-59','www.tribanco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(637,'Banco Sofisa S.A.','60.889.128/0001-80','www.sofisa.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(638,'Banco Prosper S.A.','33.876.475/0001-03','www.bancoprosper.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(641,'Banco Alvorada S.A.','33.870.163/0001-84','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(643,'Banco Pine S.A.','62.144.175/0001-20','www.bancopine.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(652,'Itaú Unibanco Holding S.A.','60.872.504/0001-23','www.itau.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(653,'Banco Indusval S.A.','61.024.352','www.bip.b.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(654,'Banco A.J.Renner S.A.','92.874.270','www.bancorenner.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(655,'Banco Votorantim S.A.','59.588.111/0001-03','www.bancovotorantim.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(707,'Banco Daycoval S.A.','62.232.889/0001-90','www.daycoval.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(719,'Banif-Banco Internacional do Funchal (Brasil)S.A.','33.884.941/0001-94','www.banif.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(721,'Banco Credibel S.A.','69.141.539/0001-67','www.credibel.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(724,'Banco Porto Seguro S.A.','62.153.721','');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(734,'Banco Gerdau S.A.','00.183.938/0001-94','www.bancogerdau.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(735,'Banco Pottencial S.A.','00.253.448/0001-17','www.pottencial.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(738,'Banco Morada S.A.','43.717.511/0001-31','www.bancomorada.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(739,'Banco Cetelem S.A.','00.558.456/0001-71','www.cetelem.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(740,'Banco Barclays S.A.','61.146.577/0001-09','www.barclays.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(741,'Banco Ribeirão Preto S.A.','00.517.645/0001-04','www.brp.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(743,'Banco Semear S.A.','00.795.423/0001-45','www.bancosemear.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(744,'BankBoston N.A.','33.140.666/0001-02','www.tb_bancoboston.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(745,'Banco CitiBank S.A.','33.479.023/0001-80','www.cititb_banco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(746,'Banco Modal S.A.','30.723.886/0001-62','www.bancomodal.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(747,'Banco RaboBank International Brasil S.A.','01.023.570/0001-60','www.rabotb_banco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(748,'Banco Cooperativo Sicredi S.A.','01.181.521/0001-55','www.sicredi.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(749,'Banco Simples S.A.','10.995.587/0001-70','www.bancosimples.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(751,'ScotiaBank Brasil S.A. Banco Múltiplo','29.030.467/0001-66','www.br.scotiatb_banco.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(752,'Banco BNP Paribas Brasil S.A.','01.522.368/0001-82','www.bnpparibas.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(753,'NBC Bank Brasil S.A. - Banco Múltiplo','74.828.799/0001-45','www.nbctb_banco.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(755,'Bank of America Merrill Lynch Banco Múltiplo S.A.','62.073.200/0001-21','www.ml.com');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(756,'Banco Cooperativo do Brasil S.A. - BANCOOB','02.038.232/0001-64','www.bancoob.com.br');
insert into financial.tb_bank(ci_bank,nm_bank,nr_cnpj,ds_site) values(757,'Banco KEB do Brasil S.A.','02.318.507/0001-13','www.bancokeb.com.br');

-------------Financial---------
insert into financial.tb_launch_document(nm_launch_document, fl_launch_document, nr_current_value, fl_active) values ('BOLETO', 'ALPHANUMERIC', 0, true);
insert into financial.tb_launch_document_origin(nm_launch_document_origin, fl_launch_document_origin, fl_active) values ('NOTA FISCAL - SERVIÇOS', 'ALPHANUMERIC', true);
insert into financial.tb_bank_account(cd_bank, cd_agency, nr_account, nm_account, dt_start, nr_limit)
values(1, 1180, '372625', 'CONTA PRINCIPAL BB', '2000-01-01', 50000);
insert into financial.tb_account(nm_account, cd_bank, cd_agency, nr_account, cd_workgroup, fl_active)
values('PRINCIPAL BB',  1, 1180, '372625', 2, true);