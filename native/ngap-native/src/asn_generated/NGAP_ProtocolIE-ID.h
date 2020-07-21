/*
 * Generated by asn1c-0.9.29 (http://lionet.info/asn1c)
 * From ASN.1 module "NGAP-CommonDataTypes"
 * 	found in "asn/NGAP-CommonDataTypes.asn"
 * 	`asn1c -fcompound-names -findirect-choice -fno-include-deps -gen-PER -no-gen-OER -no-gen-example -D ngap -pdu=all`
 */

#ifndef	_NGAP_ProtocolIE_ID_H_
#define	_NGAP_ProtocolIE_ID_H_


#include <asn_application.h>

/* Including external dependencies */
#include <NativeInteger.h>

#ifdef __cplusplus
extern "C" {
#endif

/* NGAP_ProtocolIE-ID */
typedef long	 NGAP_ProtocolIE_ID_t;

/* Implementation */
extern asn_per_constraints_t asn_PER_type_NGAP_ProtocolIE_ID_constr_1;
extern asn_TYPE_descriptor_t asn_DEF_NGAP_ProtocolIE_ID;
asn_struct_free_f NGAP_ProtocolIE_ID_free;
asn_struct_print_f NGAP_ProtocolIE_ID_print;
asn_constr_check_f NGAP_ProtocolIE_ID_constraint;
ber_type_decoder_f NGAP_ProtocolIE_ID_decode_ber;
der_type_encoder_f NGAP_ProtocolIE_ID_encode_der;
xer_type_decoder_f NGAP_ProtocolIE_ID_decode_xer;
xer_type_encoder_f NGAP_ProtocolIE_ID_encode_xer;
per_type_decoder_f NGAP_ProtocolIE_ID_decode_uper;
per_type_encoder_f NGAP_ProtocolIE_ID_encode_uper;
per_type_decoder_f NGAP_ProtocolIE_ID_decode_aper;
per_type_encoder_f NGAP_ProtocolIE_ID_encode_aper;
#define NGAP_ProtocolIE_ID_id_AllowedNSSAI	((NGAP_ProtocolIE_ID_t)0)
#define NGAP_ProtocolIE_ID_id_AMFName	((NGAP_ProtocolIE_ID_t)1)
#define NGAP_ProtocolIE_ID_id_AMFOverloadResponse	((NGAP_ProtocolIE_ID_t)2)
#define NGAP_ProtocolIE_ID_id_AMFSetID	((NGAP_ProtocolIE_ID_t)3)
#define NGAP_ProtocolIE_ID_id_AMF_TNLAssociationFailedToSetupList	((NGAP_ProtocolIE_ID_t)4)
#define NGAP_ProtocolIE_ID_id_AMF_TNLAssociationSetupList	((NGAP_ProtocolIE_ID_t)5)
#define NGAP_ProtocolIE_ID_id_AMF_TNLAssociationToAddList	((NGAP_ProtocolIE_ID_t)6)
#define NGAP_ProtocolIE_ID_id_AMF_TNLAssociationToRemoveList	((NGAP_ProtocolIE_ID_t)7)
#define NGAP_ProtocolIE_ID_id_AMF_TNLAssociationToUpdateList	((NGAP_ProtocolIE_ID_t)8)
#define NGAP_ProtocolIE_ID_id_AMFTrafficLoadReductionIndication	((NGAP_ProtocolIE_ID_t)9)
#define NGAP_ProtocolIE_ID_id_AMF_UE_NGAP_ID	((NGAP_ProtocolIE_ID_t)10)
#define NGAP_ProtocolIE_ID_id_AssistanceDataForPaging	((NGAP_ProtocolIE_ID_t)11)
#define NGAP_ProtocolIE_ID_id_BroadcastCancelledAreaList	((NGAP_ProtocolIE_ID_t)12)
#define NGAP_ProtocolIE_ID_id_BroadcastCompletedAreaList	((NGAP_ProtocolIE_ID_t)13)
#define NGAP_ProtocolIE_ID_id_CancelAllWarningMessages	((NGAP_ProtocolIE_ID_t)14)
#define NGAP_ProtocolIE_ID_id_Cause	((NGAP_ProtocolIE_ID_t)15)
#define NGAP_ProtocolIE_ID_id_CellIDListForRestart	((NGAP_ProtocolIE_ID_t)16)
#define NGAP_ProtocolIE_ID_id_ConcurrentWarningMessageInd	((NGAP_ProtocolIE_ID_t)17)
#define NGAP_ProtocolIE_ID_id_CoreNetworkAssistanceInformation	((NGAP_ProtocolIE_ID_t)18)
#define NGAP_ProtocolIE_ID_id_CriticalityDiagnostics	((NGAP_ProtocolIE_ID_t)19)
#define NGAP_ProtocolIE_ID_id_DataCodingScheme	((NGAP_ProtocolIE_ID_t)20)
#define NGAP_ProtocolIE_ID_id_DefaultPagingDRX	((NGAP_ProtocolIE_ID_t)21)
#define NGAP_ProtocolIE_ID_id_DirectForwardingPathAvailability	((NGAP_ProtocolIE_ID_t)22)
#define NGAP_ProtocolIE_ID_id_EmergencyAreaIDListForRestart	((NGAP_ProtocolIE_ID_t)23)
#define NGAP_ProtocolIE_ID_id_EmergencyFallbackIndicator	((NGAP_ProtocolIE_ID_t)24)
#define NGAP_ProtocolIE_ID_id_EUTRA_CGI	((NGAP_ProtocolIE_ID_t)25)
#define NGAP_ProtocolIE_ID_id_FiveG_S_TMSI	((NGAP_ProtocolIE_ID_t)26)
#define NGAP_ProtocolIE_ID_id_GlobalRANNodeID	((NGAP_ProtocolIE_ID_t)27)
#define NGAP_ProtocolIE_ID_id_GUAMI	((NGAP_ProtocolIE_ID_t)28)
#define NGAP_ProtocolIE_ID_id_HandoverType	((NGAP_ProtocolIE_ID_t)29)
#define NGAP_ProtocolIE_ID_id_IMSVoiceSupportIndicator	((NGAP_ProtocolIE_ID_t)30)
#define NGAP_ProtocolIE_ID_id_IndexToRFSP	((NGAP_ProtocolIE_ID_t)31)
#define NGAP_ProtocolIE_ID_id_InfoOnRecommendedCellsAndRANNodesForPaging	((NGAP_ProtocolIE_ID_t)32)
#define NGAP_ProtocolIE_ID_id_LocationReportingRequestType	((NGAP_ProtocolIE_ID_t)33)
#define NGAP_ProtocolIE_ID_id_MaskedIMEISV	((NGAP_ProtocolIE_ID_t)34)
#define NGAP_ProtocolIE_ID_id_MessageIdentifier	((NGAP_ProtocolIE_ID_t)35)
#define NGAP_ProtocolIE_ID_id_MobilityRestrictionList	((NGAP_ProtocolIE_ID_t)36)
#define NGAP_ProtocolIE_ID_id_NASC	((NGAP_ProtocolIE_ID_t)37)
#define NGAP_ProtocolIE_ID_id_NAS_PDU	((NGAP_ProtocolIE_ID_t)38)
#define NGAP_ProtocolIE_ID_id_NASSecurityParametersFromNGRAN	((NGAP_ProtocolIE_ID_t)39)
#define NGAP_ProtocolIE_ID_id_NewAMF_UE_NGAP_ID	((NGAP_ProtocolIE_ID_t)40)
#define NGAP_ProtocolIE_ID_id_NewSecurityContextInd	((NGAP_ProtocolIE_ID_t)41)
#define NGAP_ProtocolIE_ID_id_NGAP_Message	((NGAP_ProtocolIE_ID_t)42)
#define NGAP_ProtocolIE_ID_id_NGRAN_CGI	((NGAP_ProtocolIE_ID_t)43)
#define NGAP_ProtocolIE_ID_id_NGRANTraceID	((NGAP_ProtocolIE_ID_t)44)
#define NGAP_ProtocolIE_ID_id_NR_CGI	((NGAP_ProtocolIE_ID_t)45)
#define NGAP_ProtocolIE_ID_id_NRPPa_PDU	((NGAP_ProtocolIE_ID_t)46)
#define NGAP_ProtocolIE_ID_id_NumberOfBroadcastsRequested	((NGAP_ProtocolIE_ID_t)47)
#define NGAP_ProtocolIE_ID_id_OldAMF	((NGAP_ProtocolIE_ID_t)48)
#define NGAP_ProtocolIE_ID_id_OverloadStartNSSAIList	((NGAP_ProtocolIE_ID_t)49)
#define NGAP_ProtocolIE_ID_id_PagingDRX	((NGAP_ProtocolIE_ID_t)50)
#define NGAP_ProtocolIE_ID_id_PagingOrigin	((NGAP_ProtocolIE_ID_t)51)
#define NGAP_ProtocolIE_ID_id_PagingPriority	((NGAP_ProtocolIE_ID_t)52)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceAdmittedList	((NGAP_ProtocolIE_ID_t)53)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToModifyListModRes	((NGAP_ProtocolIE_ID_t)54)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToSetupListCxtRes	((NGAP_ProtocolIE_ID_t)55)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToSetupListHOAck	((NGAP_ProtocolIE_ID_t)56)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToSetupListPSReq	((NGAP_ProtocolIE_ID_t)57)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToSetupListSURes	((NGAP_ProtocolIE_ID_t)58)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceHandoverList	((NGAP_ProtocolIE_ID_t)59)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceListCxtRelCpl	((NGAP_ProtocolIE_ID_t)60)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceListHORqd	((NGAP_ProtocolIE_ID_t)61)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceModifyListModCfm	((NGAP_ProtocolIE_ID_t)62)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceModifyListModInd	((NGAP_ProtocolIE_ID_t)63)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceModifyListModReq	((NGAP_ProtocolIE_ID_t)64)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceModifyListModRes	((NGAP_ProtocolIE_ID_t)65)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceNotifyList	((NGAP_ProtocolIE_ID_t)66)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceReleasedListNot	((NGAP_ProtocolIE_ID_t)67)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceReleasedListPSAck	((NGAP_ProtocolIE_ID_t)68)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceReleasedListPSFail	((NGAP_ProtocolIE_ID_t)69)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceReleasedListRelRes	((NGAP_ProtocolIE_ID_t)70)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceSetupListCxtReq	((NGAP_ProtocolIE_ID_t)71)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceSetupListCxtRes	((NGAP_ProtocolIE_ID_t)72)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceSetupListHOReq	((NGAP_ProtocolIE_ID_t)73)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceSetupListSUReq	((NGAP_ProtocolIE_ID_t)74)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceSetupListSURes	((NGAP_ProtocolIE_ID_t)75)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceToBeSwitchedDLList	((NGAP_ProtocolIE_ID_t)76)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceSwitchedList	((NGAP_ProtocolIE_ID_t)77)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceToReleaseListHOCmd	((NGAP_ProtocolIE_ID_t)78)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceToReleaseListRelCmd	((NGAP_ProtocolIE_ID_t)79)
#define NGAP_ProtocolIE_ID_id_PLMNSupportList	((NGAP_ProtocolIE_ID_t)80)
#define NGAP_ProtocolIE_ID_id_PWSFailedCellIDList	((NGAP_ProtocolIE_ID_t)81)
#define NGAP_ProtocolIE_ID_id_RANNodeName	((NGAP_ProtocolIE_ID_t)82)
#define NGAP_ProtocolIE_ID_id_RANPagingPriority	((NGAP_ProtocolIE_ID_t)83)
#define NGAP_ProtocolIE_ID_id_RANStatusTransfer_TransparentContainer	((NGAP_ProtocolIE_ID_t)84)
#define NGAP_ProtocolIE_ID_id_RAN_UE_NGAP_ID	((NGAP_ProtocolIE_ID_t)85)
#define NGAP_ProtocolIE_ID_id_RelativeAMFCapacity	((NGAP_ProtocolIE_ID_t)86)
#define NGAP_ProtocolIE_ID_id_RepetitionPeriod	((NGAP_ProtocolIE_ID_t)87)
#define NGAP_ProtocolIE_ID_id_ResetType	((NGAP_ProtocolIE_ID_t)88)
#define NGAP_ProtocolIE_ID_id_RoutingID	((NGAP_ProtocolIE_ID_t)89)
#define NGAP_ProtocolIE_ID_id_RRCEstablishmentCause	((NGAP_ProtocolIE_ID_t)90)
#define NGAP_ProtocolIE_ID_id_RRCInactiveTransitionReportRequest	((NGAP_ProtocolIE_ID_t)91)
#define NGAP_ProtocolIE_ID_id_RRCState	((NGAP_ProtocolIE_ID_t)92)
#define NGAP_ProtocolIE_ID_id_SecurityContext	((NGAP_ProtocolIE_ID_t)93)
#define NGAP_ProtocolIE_ID_id_SecurityKey	((NGAP_ProtocolIE_ID_t)94)
#define NGAP_ProtocolIE_ID_id_SerialNumber	((NGAP_ProtocolIE_ID_t)95)
#define NGAP_ProtocolIE_ID_id_ServedGUAMIList	((NGAP_ProtocolIE_ID_t)96)
#define NGAP_ProtocolIE_ID_id_SliceSupportList	((NGAP_ProtocolIE_ID_t)97)
#define NGAP_ProtocolIE_ID_id_SONConfigurationTransferDL	((NGAP_ProtocolIE_ID_t)98)
#define NGAP_ProtocolIE_ID_id_SONConfigurationTransferUL	((NGAP_ProtocolIE_ID_t)99)
#define NGAP_ProtocolIE_ID_id_SourceAMF_UE_NGAP_ID	((NGAP_ProtocolIE_ID_t)100)
#define NGAP_ProtocolIE_ID_id_SourceToTarget_TransparentContainer	((NGAP_ProtocolIE_ID_t)101)
#define NGAP_ProtocolIE_ID_id_SupportedTAList	((NGAP_ProtocolIE_ID_t)102)
#define NGAP_ProtocolIE_ID_id_TAIListForPaging	((NGAP_ProtocolIE_ID_t)103)
#define NGAP_ProtocolIE_ID_id_TAIListForRestart	((NGAP_ProtocolIE_ID_t)104)
#define NGAP_ProtocolIE_ID_id_TargetID	((NGAP_ProtocolIE_ID_t)105)
#define NGAP_ProtocolIE_ID_id_TargetToSource_TransparentContainer	((NGAP_ProtocolIE_ID_t)106)
#define NGAP_ProtocolIE_ID_id_TimeToWait	((NGAP_ProtocolIE_ID_t)107)
#define NGAP_ProtocolIE_ID_id_TraceActivation	((NGAP_ProtocolIE_ID_t)108)
#define NGAP_ProtocolIE_ID_id_TraceCollectionEntityIPAddress	((NGAP_ProtocolIE_ID_t)109)
#define NGAP_ProtocolIE_ID_id_UEAggregateMaximumBitRate	((NGAP_ProtocolIE_ID_t)110)
#define NGAP_ProtocolIE_ID_id_UE_associatedLogicalNG_connectionList	((NGAP_ProtocolIE_ID_t)111)
#define NGAP_ProtocolIE_ID_id_UEContextRequest	((NGAP_ProtocolIE_ID_t)112)
#define NGAP_ProtocolIE_ID_id_Unknown_113	((NGAP_ProtocolIE_ID_t)113)
#define NGAP_ProtocolIE_ID_id_UE_NGAP_IDs	((NGAP_ProtocolIE_ID_t)114)
#define NGAP_ProtocolIE_ID_id_UEPagingIdentity	((NGAP_ProtocolIE_ID_t)115)
#define NGAP_ProtocolIE_ID_id_UEPresenceInAreaOfInterestList	((NGAP_ProtocolIE_ID_t)116)
#define NGAP_ProtocolIE_ID_id_UERadioCapability	((NGAP_ProtocolIE_ID_t)117)
#define NGAP_ProtocolIE_ID_id_UERadioCapabilityForPaging	((NGAP_ProtocolIE_ID_t)118)
#define NGAP_ProtocolIE_ID_id_UESecurityCapabilities	((NGAP_ProtocolIE_ID_t)119)
#define NGAP_ProtocolIE_ID_id_UnavailableGUAMIList	((NGAP_ProtocolIE_ID_t)120)
#define NGAP_ProtocolIE_ID_id_UserLocationInformation	((NGAP_ProtocolIE_ID_t)121)
#define NGAP_ProtocolIE_ID_id_WarningAreaList	((NGAP_ProtocolIE_ID_t)122)
#define NGAP_ProtocolIE_ID_id_WarningMessageContents	((NGAP_ProtocolIE_ID_t)123)
#define NGAP_ProtocolIE_ID_id_WarningSecurityInfo	((NGAP_ProtocolIE_ID_t)124)
#define NGAP_ProtocolIE_ID_id_WarningType	((NGAP_ProtocolIE_ID_t)125)
#define NGAP_ProtocolIE_ID_id_AdditionalUL_NGU_UP_TNLInformation	((NGAP_ProtocolIE_ID_t)126)
#define NGAP_ProtocolIE_ID_id_DataForwardingNotPossible	((NGAP_ProtocolIE_ID_t)127)
#define NGAP_ProtocolIE_ID_id_DL_NGU_UP_TNLInformation	((NGAP_ProtocolIE_ID_t)128)
#define NGAP_ProtocolIE_ID_id_NetworkInstance	((NGAP_ProtocolIE_ID_t)129)
#define NGAP_ProtocolIE_ID_id_PDUSessionAggregateMaximumBitRate	((NGAP_ProtocolIE_ID_t)130)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToModifyListModCfm	((NGAP_ProtocolIE_ID_t)131)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceFailedToSetupListCxtFail	((NGAP_ProtocolIE_ID_t)132)
#define NGAP_ProtocolIE_ID_id_PDUSessionResourceListCxtRelReq	((NGAP_ProtocolIE_ID_t)133)
#define NGAP_ProtocolIE_ID_id_PDUSessionType	((NGAP_ProtocolIE_ID_t)134)
#define NGAP_ProtocolIE_ID_id_QosFlowAddOrModifyRequestList	((NGAP_ProtocolIE_ID_t)135)
#define NGAP_ProtocolIE_ID_id_QosFlowSetupRequestList	((NGAP_ProtocolIE_ID_t)136)
#define NGAP_ProtocolIE_ID_id_QosFlowToReleaseList	((NGAP_ProtocolIE_ID_t)137)
#define NGAP_ProtocolIE_ID_id_SecurityIndication	((NGAP_ProtocolIE_ID_t)138)
#define NGAP_ProtocolIE_ID_id_UL_NGU_UP_TNLInformation	((NGAP_ProtocolIE_ID_t)139)
#define NGAP_ProtocolIE_ID_id_UL_NGU_UP_TNLModifyList	((NGAP_ProtocolIE_ID_t)140)
#define NGAP_ProtocolIE_ID_id_WarningAreaCoordinates	((NGAP_ProtocolIE_ID_t)141)

#ifdef __cplusplus
}
#endif

#endif	/* _NGAP_ProtocolIE_ID_H_ */
#include <asn_internal.h>
