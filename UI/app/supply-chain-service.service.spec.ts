import { TestBed } from '@angular/core/testing';

import { SupplyChainServiceService } from './supply-chain-service.service';

describe('SupplyChainServiceService', () => {
  let service: SupplyChainServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupplyChainServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
