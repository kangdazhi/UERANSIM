/*
 * Generated by asn1c-0.9.29 (http://lionet.info/asn1c)
 * From ASN.1 module "NGAP-IEs"
 * 	found in "asn/NGAP-IEs.asn"
 * 	`asn1c -fcompound-names -findirect-choice -fno-include-deps -gen-PER -no-gen-OER -no-gen-example -D ngap -pdu=all`
 */

#ifndef	_NGAP_PDUSessionResourceModifyListModReq_H_
#define	_NGAP_PDUSessionResourceModifyListModReq_H_


#include <asn_application.h>

/* Including external dependencies */
#include <asn_SEQUENCE_OF.h>
#include <constr_SEQUENCE_OF.h>

#ifdef __cplusplus
extern "C" {
#endif

/* Forward declarations */
struct NGAP_PDUSessionResourceModifyItemModReq;

/* NGAP_PDUSessionResourceModifyListModReq */
typedef struct NGAP_PDUSessionResourceModifyListModReq {
	A_SEQUENCE_OF(struct NGAP_PDUSessionResourceModifyItemModReq) list;
	
	/* Context for parsing across buffer boundaries */
	asn_struct_ctx_t _asn_ctx;
} NGAP_PDUSessionResourceModifyListModReq_t;

/* Implementation */
extern asn_TYPE_descriptor_t asn_DEF_NGAP_PDUSessionResourceModifyListModReq;
extern asn_SET_OF_specifics_t asn_SPC_NGAP_PDUSessionResourceModifyListModReq_specs_1;
extern asn_TYPE_member_t asn_MBR_NGAP_PDUSessionResourceModifyListModReq_1[1];
extern asn_per_constraints_t asn_PER_type_NGAP_PDUSessionResourceModifyListModReq_constr_1;

#ifdef __cplusplus
}
#endif

#endif	/* _NGAP_PDUSessionResourceModifyListModReq_H_ */
#include <asn_internal.h>
